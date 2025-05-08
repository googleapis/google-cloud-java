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
package com.google.cloud.lustre.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service describing handlers for resources
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/lustre/v1/lustre.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class LustreGrpc {

  private LustreGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.lustre.v1.Lustre";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.ListInstancesRequest,
          com.google.cloud.lustre.v1.ListInstancesResponse>
      getListInstancesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListInstances",
      requestType = com.google.cloud.lustre.v1.ListInstancesRequest.class,
      responseType = com.google.cloud.lustre.v1.ListInstancesResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.ListInstancesRequest,
          com.google.cloud.lustre.v1.ListInstancesResponse>
      getListInstancesMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.lustre.v1.ListInstancesRequest,
            com.google.cloud.lustre.v1.ListInstancesResponse>
        getListInstancesMethod;
    if ((getListInstancesMethod = LustreGrpc.getListInstancesMethod) == null) {
      synchronized (LustreGrpc.class) {
        if ((getListInstancesMethod = LustreGrpc.getListInstancesMethod) == null) {
          LustreGrpc.getListInstancesMethod =
              getListInstancesMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.lustre.v1.ListInstancesRequest,
                          com.google.cloud.lustre.v1.ListInstancesResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListInstances"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.ListInstancesRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.ListInstancesResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new LustreMethodDescriptorSupplier("ListInstances"))
                      .build();
        }
      }
    }
    return getListInstancesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.GetInstanceRequest, com.google.cloud.lustre.v1.Instance>
      getGetInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetInstance",
      requestType = com.google.cloud.lustre.v1.GetInstanceRequest.class,
      responseType = com.google.cloud.lustre.v1.Instance.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.GetInstanceRequest, com.google.cloud.lustre.v1.Instance>
      getGetInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.lustre.v1.GetInstanceRequest, com.google.cloud.lustre.v1.Instance>
        getGetInstanceMethod;
    if ((getGetInstanceMethod = LustreGrpc.getGetInstanceMethod) == null) {
      synchronized (LustreGrpc.class) {
        if ((getGetInstanceMethod = LustreGrpc.getGetInstanceMethod) == null) {
          LustreGrpc.getGetInstanceMethod =
              getGetInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.lustre.v1.GetInstanceRequest,
                          com.google.cloud.lustre.v1.Instance>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.GetInstanceRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.Instance.getDefaultInstance()))
                      .setSchemaDescriptor(new LustreMethodDescriptorSupplier("GetInstance"))
                      .build();
        }
      }
    }
    return getGetInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateInstance",
      requestType = com.google.cloud.lustre.v1.CreateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.CreateInstanceRequest, com.google.longrunning.Operation>
      getCreateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.lustre.v1.CreateInstanceRequest, com.google.longrunning.Operation>
        getCreateInstanceMethod;
    if ((getCreateInstanceMethod = LustreGrpc.getCreateInstanceMethod) == null) {
      synchronized (LustreGrpc.class) {
        if ((getCreateInstanceMethod = LustreGrpc.getCreateInstanceMethod) == null) {
          LustreGrpc.getCreateInstanceMethod =
              getCreateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.lustre.v1.CreateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.CreateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new LustreMethodDescriptorSupplier("CreateInstance"))
                      .build();
        }
      }
    }
    return getCreateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateInstance",
      requestType = com.google.cloud.lustre.v1.UpdateInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
      getUpdateInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.lustre.v1.UpdateInstanceRequest, com.google.longrunning.Operation>
        getUpdateInstanceMethod;
    if ((getUpdateInstanceMethod = LustreGrpc.getUpdateInstanceMethod) == null) {
      synchronized (LustreGrpc.class) {
        if ((getUpdateInstanceMethod = LustreGrpc.getUpdateInstanceMethod) == null) {
          LustreGrpc.getUpdateInstanceMethod =
              getUpdateInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.lustre.v1.UpdateInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.UpdateInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new LustreMethodDescriptorSupplier("UpdateInstance"))
                      .build();
        }
      }
    }
    return getUpdateInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteInstance",
      requestType = com.google.cloud.lustre.v1.DeleteInstanceRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
      getDeleteInstanceMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.lustre.v1.DeleteInstanceRequest, com.google.longrunning.Operation>
        getDeleteInstanceMethod;
    if ((getDeleteInstanceMethod = LustreGrpc.getDeleteInstanceMethod) == null) {
      synchronized (LustreGrpc.class) {
        if ((getDeleteInstanceMethod = LustreGrpc.getDeleteInstanceMethod) == null) {
          LustreGrpc.getDeleteInstanceMethod =
              getDeleteInstanceMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.lustre.v1.DeleteInstanceRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteInstance"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.DeleteInstanceRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new LustreMethodDescriptorSupplier("DeleteInstance"))
                      .build();
        }
      }
    }
    return getDeleteInstanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ImportData",
      requestType = com.google.cloud.lustre.v1.ImportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.ImportDataRequest, com.google.longrunning.Operation>
      getImportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.lustre.v1.ImportDataRequest, com.google.longrunning.Operation>
        getImportDataMethod;
    if ((getImportDataMethod = LustreGrpc.getImportDataMethod) == null) {
      synchronized (LustreGrpc.class) {
        if ((getImportDataMethod = LustreGrpc.getImportDataMethod) == null) {
          LustreGrpc.getImportDataMethod =
              getImportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.lustre.v1.ImportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ImportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.ImportDataRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new LustreMethodDescriptorSupplier("ImportData"))
                      .build();
        }
      }
    }
    return getImportDataMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ExportData",
      requestType = com.google.cloud.lustre.v1.ExportDataRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.lustre.v1.ExportDataRequest, com.google.longrunning.Operation>
      getExportDataMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.lustre.v1.ExportDataRequest, com.google.longrunning.Operation>
        getExportDataMethod;
    if ((getExportDataMethod = LustreGrpc.getExportDataMethod) == null) {
      synchronized (LustreGrpc.class) {
        if ((getExportDataMethod = LustreGrpc.getExportDataMethod) == null) {
          LustreGrpc.getExportDataMethod =
              getExportDataMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.lustre.v1.ExportDataRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ExportData"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.lustre.v1.ExportDataRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(new LustreMethodDescriptorSupplier("ExportData"))
                      .build();
        }
      }
    }
    return getExportDataMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static LustreStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LustreStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LustreStub>() {
          @java.lang.Override
          public LustreStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LustreStub(channel, callOptions);
          }
        };
    return LustreStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static LustreBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LustreBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LustreBlockingV2Stub>() {
          @java.lang.Override
          public LustreBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LustreBlockingV2Stub(channel, callOptions);
          }
        };
    return LustreBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LustreBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LustreBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LustreBlockingStub>() {
          @java.lang.Override
          public LustreBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LustreBlockingStub(channel, callOptions);
          }
        };
    return LustreBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static LustreFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<LustreFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<LustreFutureStub>() {
          @java.lang.Override
          public LustreFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new LustreFutureStub(channel, callOptions);
          }
        };
    return LustreFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    default void listInstances(
        com.google.cloud.lustre.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.lustre.v1.ListInstancesResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListInstancesMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    default void getInstance(
        com.google.cloud.lustre.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.lustre.v1.Instance> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    default void createInstance(
        com.google.cloud.lustre.v1.CreateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single instance.
     * </pre>
     */
    default void updateInstance(
        com.google.cloud.lustre.v1.UpdateInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    default void deleteInstance(
        com.google.cloud.lustre.v1.DeleteInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteInstanceMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Imports data from Cloud Storage to a Managed Lustre instance.
     * </pre>
     */
    default void importData(
        com.google.cloud.lustre.v1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getImportDataMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Managed Lustre instance to Cloud Storage.
     * </pre>
     */
    default void exportData(
        com.google.cloud.lustre.v1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getExportDataMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Lustre.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public abstract static class LustreImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return LustreGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Lustre.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LustreStub extends io.grpc.stub.AbstractAsyncStub<LustreStub> {
    private LustreStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LustreStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LustreStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public void listInstances(
        com.google.cloud.lustre.v1.ListInstancesRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.lustre.v1.ListInstancesResponse>
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
     * Gets details of a single instance.
     * </pre>
     */
    public void getInstance(
        com.google.cloud.lustre.v1.GetInstanceRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.lustre.v1.Instance> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public void createInstance(
        com.google.cloud.lustre.v1.CreateInstanceRequest request,
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
     * Updates the parameters of a single instance.
     * </pre>
     */
    public void updateInstance(
        com.google.cloud.lustre.v1.UpdateInstanceRequest request,
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
     * Deletes a single instance.
     * </pre>
     */
    public void deleteInstance(
        com.google.cloud.lustre.v1.DeleteInstanceRequest request,
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
     * Imports data from Cloud Storage to a Managed Lustre instance.
     * </pre>
     */
    public void importData(
        com.google.cloud.lustre.v1.ImportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Managed Lustre instance to Cloud Storage.
     * </pre>
     */
    public void exportData(
        com.google.cloud.lustre.v1.ExportDataRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Lustre.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LustreBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<LustreBlockingV2Stub> {
    private LustreBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LustreBlockingV2Stub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LustreBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.lustre.v1.ListInstancesResponse listInstances(
        com.google.cloud.lustre.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.cloud.lustre.v1.Instance getInstance(
        com.google.cloud.lustre.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.lustre.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.lustre.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.lustre.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data from Cloud Storage to a Managed Lustre instance.
     * </pre>
     */
    public com.google.longrunning.Operation importData(
        com.google.cloud.lustre.v1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Managed Lustre instance to Cloud Storage.
     * </pre>
     */
    public com.google.longrunning.Operation exportData(
        com.google.cloud.lustre.v1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service Lustre.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LustreBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<LustreBlockingStub> {
    private LustreBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LustreBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LustreBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public com.google.cloud.lustre.v1.ListInstancesResponse listInstances(
        com.google.cloud.lustre.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListInstancesMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.cloud.lustre.v1.Instance getInstance(
        com.google.cloud.lustre.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createInstance(
        com.google.cloud.lustre.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single instance.
     * </pre>
     */
    public com.google.longrunning.Operation updateInstance(
        com.google.cloud.lustre.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.longrunning.Operation deleteInstance(
        com.google.cloud.lustre.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteInstanceMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data from Cloud Storage to a Managed Lustre instance.
     * </pre>
     */
    public com.google.longrunning.Operation importData(
        com.google.cloud.lustre.v1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getImportDataMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Managed Lustre instance to Cloud Storage.
     * </pre>
     */
    public com.google.longrunning.Operation exportData(
        com.google.cloud.lustre.v1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getExportDataMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Lustre.
   *
   * <pre>
   * Service describing handlers for resources
   * </pre>
   */
  public static final class LustreFutureStub
      extends io.grpc.stub.AbstractFutureStub<LustreFutureStub> {
    private LustreFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LustreFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new LustreFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists instances in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.lustre.v1.ListInstancesResponse>
        listInstances(com.google.cloud.lustre.v1.ListInstancesRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListInstancesMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.lustre.v1.Instance>
        getInstance(com.google.cloud.lustre.v1.GetInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new instance in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createInstance(com.google.cloud.lustre.v1.CreateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the parameters of a single instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateInstance(com.google.cloud.lustre.v1.UpdateInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteInstance(com.google.cloud.lustre.v1.DeleteInstanceRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteInstanceMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Imports data from Cloud Storage to a Managed Lustre instance.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        importData(com.google.cloud.lustre.v1.ImportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getImportDataMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Exports data from a Managed Lustre instance to Cloud Storage.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        exportData(com.google.cloud.lustre.v1.ExportDataRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getExportDataMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_INSTANCES = 0;
  private static final int METHODID_GET_INSTANCE = 1;
  private static final int METHODID_CREATE_INSTANCE = 2;
  private static final int METHODID_UPDATE_INSTANCE = 3;
  private static final int METHODID_DELETE_INSTANCE = 4;
  private static final int METHODID_IMPORT_DATA = 5;
  private static final int METHODID_EXPORT_DATA = 6;

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
        case METHODID_LIST_INSTANCES:
          serviceImpl.listInstances(
              (com.google.cloud.lustre.v1.ListInstancesRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.lustre.v1.ListInstancesResponse>)
                  responseObserver);
          break;
        case METHODID_GET_INSTANCE:
          serviceImpl.getInstance(
              (com.google.cloud.lustre.v1.GetInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.lustre.v1.Instance>) responseObserver);
          break;
        case METHODID_CREATE_INSTANCE:
          serviceImpl.createInstance(
              (com.google.cloud.lustre.v1.CreateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_INSTANCE:
          serviceImpl.updateInstance(
              (com.google.cloud.lustre.v1.UpdateInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_INSTANCE:
          serviceImpl.deleteInstance(
              (com.google.cloud.lustre.v1.DeleteInstanceRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_IMPORT_DATA:
          serviceImpl.importData(
              (com.google.cloud.lustre.v1.ImportDataRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_EXPORT_DATA:
          serviceImpl.exportData(
              (com.google.cloud.lustre.v1.ExportDataRequest) request,
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
            getListInstancesMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.lustre.v1.ListInstancesRequest,
                    com.google.cloud.lustre.v1.ListInstancesResponse>(
                    service, METHODID_LIST_INSTANCES)))
        .addMethod(
            getGetInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.lustre.v1.GetInstanceRequest,
                    com.google.cloud.lustre.v1.Instance>(service, METHODID_GET_INSTANCE)))
        .addMethod(
            getCreateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.lustre.v1.CreateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_INSTANCE)))
        .addMethod(
            getUpdateInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.lustre.v1.UpdateInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_INSTANCE)))
        .addMethod(
            getDeleteInstanceMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.lustre.v1.DeleteInstanceRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_INSTANCE)))
        .addMethod(
            getImportDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.lustre.v1.ImportDataRequest, com.google.longrunning.Operation>(
                    service, METHODID_IMPORT_DATA)))
        .addMethod(
            getExportDataMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.lustre.v1.ExportDataRequest, com.google.longrunning.Operation>(
                    service, METHODID_EXPORT_DATA)))
        .build();
  }

  private abstract static class LustreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LustreBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.lustre.v1.LustreProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Lustre");
    }
  }

  private static final class LustreFileDescriptorSupplier extends LustreBaseDescriptorSupplier {
    LustreFileDescriptorSupplier() {}
  }

  private static final class LustreMethodDescriptorSupplier extends LustreBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    LustreMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (LustreGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new LustreFileDescriptorSupplier())
                      .addMethod(getListInstancesMethod())
                      .addMethod(getGetInstanceMethod())
                      .addMethod(getCreateInstanceMethod())
                      .addMethod(getUpdateInstanceMethod())
                      .addMethod(getDeleteInstanceMethod())
                      .addMethod(getImportDataMethod())
                      .addMethod(getExportDataMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
