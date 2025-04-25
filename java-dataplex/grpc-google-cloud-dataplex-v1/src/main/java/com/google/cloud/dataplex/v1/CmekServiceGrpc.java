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
package com.google.cloud.dataplex.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Dataplex Cmek Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dataplex/v1/cmek.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CmekServiceGrpc {

  private CmekServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dataplex.v1.CmekService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest,
          com.google.longrunning.Operation>
      getCreateEncryptionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEncryptionConfig",
      requestType = com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest,
          com.google.longrunning.Operation>
      getCreateEncryptionConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest,
            com.google.longrunning.Operation>
        getCreateEncryptionConfigMethod;
    if ((getCreateEncryptionConfigMethod = CmekServiceGrpc.getCreateEncryptionConfigMethod)
        == null) {
      synchronized (CmekServiceGrpc.class) {
        if ((getCreateEncryptionConfigMethod = CmekServiceGrpc.getCreateEncryptionConfigMethod)
            == null) {
          CmekServiceGrpc.getCreateEncryptionConfigMethod =
              getCreateEncryptionConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEncryptionConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekServiceMethodDescriptorSupplier("CreateEncryptionConfig"))
                      .build();
        }
      }
    }
    return getCreateEncryptionConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest,
          com.google.longrunning.Operation>
      getUpdateEncryptionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEncryptionConfig",
      requestType = com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest,
          com.google.longrunning.Operation>
      getUpdateEncryptionConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest,
            com.google.longrunning.Operation>
        getUpdateEncryptionConfigMethod;
    if ((getUpdateEncryptionConfigMethod = CmekServiceGrpc.getUpdateEncryptionConfigMethod)
        == null) {
      synchronized (CmekServiceGrpc.class) {
        if ((getUpdateEncryptionConfigMethod = CmekServiceGrpc.getUpdateEncryptionConfigMethod)
            == null) {
          CmekServiceGrpc.getUpdateEncryptionConfigMethod =
              getUpdateEncryptionConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEncryptionConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekServiceMethodDescriptorSupplier("UpdateEncryptionConfig"))
                      .build();
        }
      }
    }
    return getUpdateEncryptionConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest,
          com.google.longrunning.Operation>
      getDeleteEncryptionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteEncryptionConfig",
      requestType = com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest,
          com.google.longrunning.Operation>
      getDeleteEncryptionConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest,
            com.google.longrunning.Operation>
        getDeleteEncryptionConfigMethod;
    if ((getDeleteEncryptionConfigMethod = CmekServiceGrpc.getDeleteEncryptionConfigMethod)
        == null) {
      synchronized (CmekServiceGrpc.class) {
        if ((getDeleteEncryptionConfigMethod = CmekServiceGrpc.getDeleteEncryptionConfigMethod)
            == null) {
          CmekServiceGrpc.getDeleteEncryptionConfigMethod =
              getDeleteEncryptionConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteEncryptionConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekServiceMethodDescriptorSupplier("DeleteEncryptionConfig"))
                      .build();
        }
      }
    }
    return getDeleteEncryptionConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest,
          com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>
      getListEncryptionConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEncryptionConfigs",
      requestType = com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest.class,
      responseType = com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest,
          com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>
      getListEncryptionConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest,
            com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>
        getListEncryptionConfigsMethod;
    if ((getListEncryptionConfigsMethod = CmekServiceGrpc.getListEncryptionConfigsMethod) == null) {
      synchronized (CmekServiceGrpc.class) {
        if ((getListEncryptionConfigsMethod = CmekServiceGrpc.getListEncryptionConfigsMethod)
            == null) {
          CmekServiceGrpc.getListEncryptionConfigsMethod =
              getListEncryptionConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest,
                          com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListEncryptionConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekServiceMethodDescriptorSupplier("ListEncryptionConfigs"))
                      .build();
        }
      }
    }
    return getListEncryptionConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetEncryptionConfigRequest,
          com.google.cloud.dataplex.v1.EncryptionConfig>
      getGetEncryptionConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEncryptionConfig",
      requestType = com.google.cloud.dataplex.v1.GetEncryptionConfigRequest.class,
      responseType = com.google.cloud.dataplex.v1.EncryptionConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dataplex.v1.GetEncryptionConfigRequest,
          com.google.cloud.dataplex.v1.EncryptionConfig>
      getGetEncryptionConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dataplex.v1.GetEncryptionConfigRequest,
            com.google.cloud.dataplex.v1.EncryptionConfig>
        getGetEncryptionConfigMethod;
    if ((getGetEncryptionConfigMethod = CmekServiceGrpc.getGetEncryptionConfigMethod) == null) {
      synchronized (CmekServiceGrpc.class) {
        if ((getGetEncryptionConfigMethod = CmekServiceGrpc.getGetEncryptionConfigMethod) == null) {
          CmekServiceGrpc.getGetEncryptionConfigMethod =
              getGetEncryptionConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dataplex.v1.GetEncryptionConfigRequest,
                          com.google.cloud.dataplex.v1.EncryptionConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetEncryptionConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.GetEncryptionConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dataplex.v1.EncryptionConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekServiceMethodDescriptorSupplier("GetEncryptionConfig"))
                      .build();
        }
      }
    }
    return getGetEncryptionConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CmekServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekServiceStub>() {
          @java.lang.Override
          public CmekServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekServiceStub(channel, callOptions);
          }
        };
    return CmekServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CmekServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekServiceBlockingV2Stub>() {
          @java.lang.Override
          public CmekServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CmekServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CmekServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekServiceBlockingStub>() {
          @java.lang.Override
          public CmekServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekServiceBlockingStub(channel, callOptions);
          }
        };
    return CmekServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CmekServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekServiceFutureStub>() {
          @java.lang.Override
          public CmekServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekServiceFutureStub(channel, callOptions);
          }
        };
    return CmekServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Dataplex Cmek Service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Create an EncryptionConfig.
     * </pre>
     */
    default void createEncryptionConfig(
        com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEncryptionConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an EncryptionConfig.
     * </pre>
     */
    default void updateEncryptionConfig(
        com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEncryptionConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an EncryptionConfig.
     * </pre>
     */
    default void deleteEncryptionConfig(
        com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteEncryptionConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List EncryptionConfigs.
     * </pre>
     */
    default void listEncryptionConfigs(
        com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEncryptionConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an EncryptionConfig.
     * </pre>
     */
    default void getEncryptionConfig(
        com.google.cloud.dataplex.v1.GetEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EncryptionConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEncryptionConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CmekService.
   *
   * <pre>
   * Dataplex Cmek Service
   * </pre>
   */
  public abstract static class CmekServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CmekServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CmekService.
   *
   * <pre>
   * Dataplex Cmek Service
   * </pre>
   */
  public static final class CmekServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CmekServiceStub> {
    private CmekServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an EncryptionConfig.
     * </pre>
     */
    public void createEncryptionConfig(
        com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEncryptionConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Update an EncryptionConfig.
     * </pre>
     */
    public void updateEncryptionConfig(
        com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEncryptionConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete an EncryptionConfig.
     * </pre>
     */
    public void deleteEncryptionConfig(
        com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteEncryptionConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List EncryptionConfigs.
     * </pre>
     */
    public void listEncryptionConfigs(
        com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEncryptionConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Get an EncryptionConfig.
     * </pre>
     */
    public void getEncryptionConfig(
        com.google.cloud.dataplex.v1.GetEncryptionConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EncryptionConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEncryptionConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CmekService.
   *
   * <pre>
   * Dataplex Cmek Service
   * </pre>
   */
  public static final class CmekServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CmekServiceBlockingV2Stub> {
    private CmekServiceBlockingV2Stub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an EncryptionConfig.
     * </pre>
     */
    public com.google.longrunning.Operation createEncryptionConfig(
        com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEncryptionConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an EncryptionConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateEncryptionConfig(
        com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEncryptionConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an EncryptionConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEncryptionConfig(
        com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEncryptionConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List EncryptionConfigs.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse listEncryptionConfigs(
        com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEncryptionConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get an EncryptionConfig.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.EncryptionConfig getEncryptionConfig(
        com.google.cloud.dataplex.v1.GetEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEncryptionConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CmekService.
   *
   * <pre>
   * Dataplex Cmek Service
   * </pre>
   */
  public static final class CmekServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CmekServiceBlockingStub> {
    private CmekServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an EncryptionConfig.
     * </pre>
     */
    public com.google.longrunning.Operation createEncryptionConfig(
        com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEncryptionConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Update an EncryptionConfig.
     * </pre>
     */
    public com.google.longrunning.Operation updateEncryptionConfig(
        com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEncryptionConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an EncryptionConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteEncryptionConfig(
        com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteEncryptionConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List EncryptionConfigs.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse listEncryptionConfigs(
        com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEncryptionConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Get an EncryptionConfig.
     * </pre>
     */
    public com.google.cloud.dataplex.v1.EncryptionConfig getEncryptionConfig(
        com.google.cloud.dataplex.v1.GetEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEncryptionConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CmekService.
   *
   * <pre>
   * Dataplex Cmek Service
   * </pre>
   */
  public static final class CmekServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CmekServiceFutureStub> {
    private CmekServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Create an EncryptionConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createEncryptionConfig(com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEncryptionConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Update an EncryptionConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateEncryptionConfig(com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEncryptionConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete an EncryptionConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteEncryptionConfig(com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteEncryptionConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * List EncryptionConfigs.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>
        listEncryptionConfigs(com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEncryptionConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Get an EncryptionConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dataplex.v1.EncryptionConfig>
        getEncryptionConfig(com.google.cloud.dataplex.v1.GetEncryptionConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEncryptionConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_ENCRYPTION_CONFIG = 0;
  private static final int METHODID_UPDATE_ENCRYPTION_CONFIG = 1;
  private static final int METHODID_DELETE_ENCRYPTION_CONFIG = 2;
  private static final int METHODID_LIST_ENCRYPTION_CONFIGS = 3;
  private static final int METHODID_GET_ENCRYPTION_CONFIG = 4;

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
        case METHODID_CREATE_ENCRYPTION_CONFIG:
          serviceImpl.createEncryptionConfig(
              (com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_UPDATE_ENCRYPTION_CONFIG:
          serviceImpl.updateEncryptionConfig(
              (com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_ENCRYPTION_CONFIG:
          serviceImpl.deleteEncryptionConfig(
              (com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_LIST_ENCRYPTION_CONFIGS:
          serviceImpl.listEncryptionConfigs(
              (com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_ENCRYPTION_CONFIG:
          serviceImpl.getEncryptionConfig(
              (com.google.cloud.dataplex.v1.GetEncryptionConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dataplex.v1.EncryptionConfig>)
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
            getCreateEncryptionConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.CreateEncryptionConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_ENCRYPTION_CONFIG)))
        .addMethod(
            getUpdateEncryptionConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.UpdateEncryptionConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_ENCRYPTION_CONFIG)))
        .addMethod(
            getDeleteEncryptionConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.DeleteEncryptionConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_ENCRYPTION_CONFIG)))
        .addMethod(
            getListEncryptionConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.ListEncryptionConfigsRequest,
                    com.google.cloud.dataplex.v1.ListEncryptionConfigsResponse>(
                    service, METHODID_LIST_ENCRYPTION_CONFIGS)))
        .addMethod(
            getGetEncryptionConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dataplex.v1.GetEncryptionConfigRequest,
                    com.google.cloud.dataplex.v1.EncryptionConfig>(
                    service, METHODID_GET_ENCRYPTION_CONFIG)))
        .build();
  }

  private abstract static class CmekServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CmekServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dataplex.v1.CmekProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CmekService");
    }
  }

  private static final class CmekServiceFileDescriptorSupplier
      extends CmekServiceBaseDescriptorSupplier {
    CmekServiceFileDescriptorSupplier() {}
  }

  private static final class CmekServiceMethodDescriptorSupplier
      extends CmekServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CmekServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CmekServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CmekServiceFileDescriptorSupplier())
                      .addMethod(getCreateEncryptionConfigMethod())
                      .addMethod(getUpdateEncryptionConfigMethod())
                      .addMethod(getDeleteEncryptionConfigMethod())
                      .addMethod(getListEncryptionConfigsMethod())
                      .addMethod(getGetEncryptionConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
