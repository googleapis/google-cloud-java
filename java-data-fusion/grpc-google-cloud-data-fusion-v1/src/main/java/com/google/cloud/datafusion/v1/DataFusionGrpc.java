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
package com.google.cloud.datafusion.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for creating and managing Data Fusion instances.
 * Data Fusion enables ETL developers to build code-free, data integration
 * pipelines via a point-and-click UI.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/datafusion/v1/datafusion.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class DataFusionGrpc {

  private DataFusionGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.datafusion.v1.DataFusion";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.ListAvailableVersionsRequest,
          com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>
      getListAvailableVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListAvailableVersions",
      requestType = com.google.cloud.datafusion.v1.ListAvailableVersionsRequest.class,
      responseType = com.google.cloud.datafusion.v1.ListAvailableVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.ListAvailableVersionsRequest,
          com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>
      getListAvailableVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datafusion.v1.ListAvailableVersionsRequest,
            com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>
        getListAvailableVersionsMethod;
    if ((getListAvailableVersionsMethod = DataFusionGrpc.getListAvailableVersionsMethod) == null) {
      synchronized (DataFusionGrpc.class) {
        if ((getListAvailableVersionsMethod = DataFusionGrpc.getListAvailableVersionsMethod)
            == null) {
          DataFusionGrpc.getListAvailableVersionsMethod =
              getListAvailableVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datafusion.v1.ListAvailableVersionsRequest,
                          com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListAvailableVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.ListAvailableVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.ListAvailableVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataFusionMethodDescriptorSupplier("ListAvailableVersions"))
                      .build();
        }
      }
    }
    return getListAvailableVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.ListInstancesRequest,
          com.google.cloud.datafusion.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.datafusion.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.datafusion.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.ListInstancesRequest,
          com.google.cloud.datafusion.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datafusion.v1.ListInstancesRequest,
            com.google.cloud.datafusion.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = DataFusionGrpc.getListInstancesMethod) == null) {
      synchronized (DataFusionGrpc.class) {
        if ((getListInstancesMethod = DataFusionGrpc.getListInstancesMethod) == null) {
          DataFusionGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datafusion.v1.ListInstancesRequest,
                          com.google.cloud.datafusion.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.ListInstancesRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new DataFusionMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.GetInstanceRequest,
          com.google.cloud.datafusion.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.datafusion.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.datafusion.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.GetInstanceRequest,
          com.google.cloud.datafusion.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datafusion.v1.GetInstanceRequest,
            com.google.cloud.datafusion.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = DataFusionGrpc.getGetInstanceMethod) == null) {
      synchronized (DataFusionGrpc.class) {
        if ((getGetInstanceMethod = DataFusionGrpc.getGetInstanceMethod) == null) {
          DataFusionGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datafusion.v1.GetInstanceRequest,
                          com.google.cloud.datafusion.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.GetInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new DataFusionMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.datafusion.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datafusion.v1.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = DataFusionGrpc.getCreateInstanceMethod) == null) {
      synchronized (DataFusionGrpc.class) {
        if ((getCreateInstanceMethod = DataFusionGrpc.getCreateInstanceMethod) == null) {
          DataFusionGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datafusion.v1.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DataFusionMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.datafusion.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datafusion.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = DataFusionGrpc.getDeleteInstanceMethod) == null) {
      synchronized (DataFusionGrpc.class) {
        if ((getDeleteInstanceMethod = DataFusionGrpc.getDeleteInstanceMethod) == null) {
          DataFusionGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datafusion.v1.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DataFusionMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.datafusion.v1.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datafusion.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = DataFusionGrpc.getUpdateInstanceMethod) == null) {
      synchronized (DataFusionGrpc.class) {
        if ((getUpdateInstanceMethod = DataFusionGrpc.getUpdateInstanceMethod) == null) {
          DataFusionGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datafusion.v1.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new DataFusionMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.RestartInstanceRequest, com.google.longrunning.Operation>
      getRestartInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RestartInstance",
      requestType = com.google.cloud.datafusion.v1.RestartInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.datafusion.v1.RestartInstanceRequest, com.google.longrunning.Operation>
      getRestartInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.datafusion.v1.RestartInstanceRequest, com.google.longrunning.Operation>
        getRestartInstanceMethod;
    if ((getRestartInstanceMethod = DataFusionGrpc.getRestartInstanceMethod) == null) {
      synchronized (DataFusionGrpc.class) {
        if ((getRestartInstanceMethod = DataFusionGrpc.getRestartInstanceMethod) == null) {
          DataFusionGrpc.getRestartInstanceMethod =
              getRestartInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.datafusion.v1.RestartInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RestartInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.datafusion.v1.RestartInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new DataFusionMethodDescriptorSupplier("RestartInstance"))
                      .build();
        }
      }
    }
    return getRestartInstanceMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static DataFusionStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataFusionStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataFusionStub>() {
          @java.lang.Override
          public DataFusionStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataFusionStub(channel, callOptions);
          }
        };
    return DataFusionStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DataFusionBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataFusionBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataFusionBlockingStub>() {
          @java.lang.Override
          public DataFusionBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataFusionBlockingStub(channel, callOptions);
          }
        };
    return DataFusionBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static DataFusionFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<DataFusionFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<DataFusionFutureStub>() {
          @java.lang.Override
          public DataFusionFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new DataFusionFutureStub(channel, callOptions);
          }
        };
    return DataFusionFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for creating and managing Data Fusion instances.
   * Data Fusion enables ETL developers to build code-free, data integration
   * pipelines via a point-and-click UI.
   * </pre>
   */
  public abstract static class DataFusionImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists possible versions for Data Fusion instances in the specified project
     * and location.
     * </pre>
     */
    public void listAvailableVersions(
        com.google.cloud.datafusion.v1.ListAvailableVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListAvailableVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Fusion instances in the specified project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.datafusion.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Data Fusion instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.datafusion.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Data Fusion instance in the specified project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.datafusion.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Date Fusion instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.datafusion.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Data Fusion instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.datafusion.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restart a single Data Fusion instance.
     * At the end of an operation instance is fully restarted.
     * </pre>
     */
    public void restartInstance(
        com.google.cloud.datafusion.v1.RestartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRestartInstanceMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListAvailableVersionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datafusion.v1.ListAvailableVersionsRequest,
                      com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>(
                      this, METHODID_LIST_AVAILABLE_VERSIONS)))
          .addMethod(
              getListInstancesMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datafusion.v1.ListInstancesRequest,
                      com.google.cloud.datafusion.v1.ListInstancesResponse>(
                      this, METHODID_LIST_INSTANCES)))
          .addMethod(
              getGetInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datafusion.v1.GetInstanceRequest,
                      com.google.cloud.datafusion.v1.Instance>(this, METHODID_GET_INSTANCE)))
          .addMethod(
              getCreateInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datafusion.v1.CreateInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_CREATE_INSTANCE)))
          .addMethod(
              getDeleteInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datafusion.v1.DeleteInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_DELETE_INSTANCE)))
          .addMethod(
              getUpdateInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datafusion.v1.UpdateInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_UPDATE_INSTANCE)))
          .addMethod(
              getRestartInstanceMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.datafusion.v1.RestartInstanceRequest,
                      com.google.longrunning.Operation>(this, METHODID_RESTART_INSTANCE)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for creating and managing Data Fusion instances.
   * Data Fusion enables ETL developers to build code-free, data integration
   * pipelines via a point-and-click UI.
   * </pre>
   */
  public static final class DataFusionStub extends io.grpc.stub.AbstractAsyncStub<DataFusionStub> {
    private DataFusionStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataFusionStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataFusionStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists possible versions for Data Fusion instances in the specified project
     * and location.
     * </pre>
     */
    public void listAvailableVersions(
        com.google.cloud.datafusion.v1.ListAvailableVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListAvailableVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Fusion instances in the specified project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.datafusion.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Data Fusion instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.datafusion.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Data Fusion instance in the specified project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.datafusion.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Date Fusion instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.datafusion.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Data Fusion instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.datafusion.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Restart a single Data Fusion instance.
     * At the end of an operation instance is fully restarted.
     * </pre>
     */
    public void restartInstance(
        com.google.cloud.datafusion.v1.RestartInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestartInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for creating and managing Data Fusion instances.
   * Data Fusion enables ETL developers to build code-free, data integration
   * pipelines via a point-and-click UI.
   * </pre>
   */
  public static final class DataFusionBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<DataFusionBlockingStub> {
    private DataFusionBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataFusionBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataFusionBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists possible versions for Data Fusion instances in the specified project
     * and location.
     * </pre>
     */
    public com.google.cloud.datafusion.v1.ListAvailableVersionsResponse listAvailableVersions(
        com.google.cloud.datafusion.v1.ListAvailableVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListAvailableVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Fusion instances in the specified project and location.
     * </pre>
     */
    public com.google.cloud.datafusion.v1.ListInstancesResponse listInstances(
        com.google.cloud.datafusion.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Data Fusion instance.
     * </pre>
     */
    public com.google.cloud.datafusion.v1.Instance getInstance(
        com.google.cloud.datafusion.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Data Fusion instance in the specified project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.datafusion.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Date Fusion instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.datafusion.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Data Fusion instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.datafusion.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Restart a single Data Fusion instance.
     * At the end of an operation instance is fully restarted.
     * </pre>
     */
    public com.google.longrunning.Operation restartInstance(
        com.google.cloud.datafusion.v1.RestartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestartInstanceMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for creating and managing Data Fusion instances.
   * Data Fusion enables ETL developers to build code-free, data integration
   * pipelines via a point-and-click UI.
   * </pre>
   */
  public static final class DataFusionFutureStub
      extends io.grpc.stub.AbstractFutureStub<DataFusionFutureStub> {
    private DataFusionFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DataFusionFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new DataFusionFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists possible versions for Data Fusion instances in the specified project
     * and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>
        listAvailableVersions(com.google.cloud.datafusion.v1.ListAvailableVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListAvailableVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists Data Fusion instances in the specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datafusion.v1.ListInstancesResponse>
        listInstances(com.google.cloud.datafusion.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single Data Fusion instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.datafusion.v1.Instance>
        getInstance(com.google.cloud.datafusion.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new Data Fusion instance in the specified project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.datafusion.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single Date Fusion instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.datafusion.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a single Data Fusion instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.datafusion.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Restart a single Data Fusion instance.
     * At the end of an operation instance is fully restarted.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        restartInstance(com.google.cloud.datafusion.v1.RestartInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestartInstanceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_AVAILABLE_VERSIONS = 0;
  private static final int METHODID_LIST_INSTANCES = 1;
  private static final int METHODID_GET_INSTANCE = 2;
  private static final int METHODID_CREATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;
  private static final int METHODID_UPDATE_INSTANCE = 5;
  private static final int METHODID_RESTART_INSTANCE = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DataFusionImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DataFusionImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_AVAILABLE_VERSIONS:
          serviceImpl.listAvailableVersions(
              (com.google.cloud.datafusion.v1.ListAvailableVersionsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.datafusion.v1.ListAvailableVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.datafusion.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.datafusion.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.datafusion.v1.Instance>)
                  responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.datafusion.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.datafusion.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.datafusion.v1.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_RESTART_INSTANCE:
          serviceImpl.restartInstance(
              (com.google.cloud.datafusion.v1.RestartInstanceRequest) request,
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

  private abstract static class DataFusionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    DataFusionBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.datafusion.v1.Datafusion.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("DataFusion");
    }
  }

  private static final class DataFusionFileDescriptorSupplier
      extends DataFusionBaseDescriptorSupplier {
    DataFusionFileDescriptorSupplier() {}
  }

  private static final class DataFusionMethodDescriptorSupplier
      extends DataFusionBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    DataFusionMethodDescriptorSupplier(String methodName) {
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
      synchronized (DataFusionGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new DataFusionFileDescriptorSupplier())
                      .addMethod(getListAvailableVersionsMethod())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getRestartInstanceMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
