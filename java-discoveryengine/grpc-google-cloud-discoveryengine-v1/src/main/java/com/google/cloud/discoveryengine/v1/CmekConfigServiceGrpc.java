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
package com.google.cloud.discoveryengine.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for managing CMEK related tasks
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/discoveryengine/v1/cmek_config_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class CmekConfigServiceGrpc {

  private CmekConfigServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1.CmekConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest,
          com.google.longrunning.Operation>
      getUpdateCmekConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateCmekConfig",
      requestType = com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest,
          com.google.longrunning.Operation>
      getUpdateCmekConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest,
            com.google.longrunning.Operation>
        getUpdateCmekConfigMethod;
    if ((getUpdateCmekConfigMethod = CmekConfigServiceGrpc.getUpdateCmekConfigMethod) == null) {
      synchronized (CmekConfigServiceGrpc.class) {
        if ((getUpdateCmekConfigMethod = CmekConfigServiceGrpc.getUpdateCmekConfigMethod) == null) {
          CmekConfigServiceGrpc.getUpdateCmekConfigMethod =
              getUpdateCmekConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateCmekConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekConfigServiceMethodDescriptorSupplier("UpdateCmekConfig"))
                      .build();
        }
      }
    }
    return getUpdateCmekConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetCmekConfigRequest,
          com.google.cloud.discoveryengine.v1.CmekConfig>
      getGetCmekConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCmekConfig",
      requestType = com.google.cloud.discoveryengine.v1.GetCmekConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.CmekConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.GetCmekConfigRequest,
          com.google.cloud.discoveryengine.v1.CmekConfig>
      getGetCmekConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.GetCmekConfigRequest,
            com.google.cloud.discoveryengine.v1.CmekConfig>
        getGetCmekConfigMethod;
    if ((getGetCmekConfigMethod = CmekConfigServiceGrpc.getGetCmekConfigMethod) == null) {
      synchronized (CmekConfigServiceGrpc.class) {
        if ((getGetCmekConfigMethod = CmekConfigServiceGrpc.getGetCmekConfigMethod) == null) {
          CmekConfigServiceGrpc.getGetCmekConfigMethod =
              getGetCmekConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.GetCmekConfigRequest,
                          com.google.cloud.discoveryengine.v1.CmekConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetCmekConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.GetCmekConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.CmekConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekConfigServiceMethodDescriptorSupplier("GetCmekConfig"))
                      .build();
        }
      }
    }
    return getGetCmekConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest,
          com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>
      getListCmekConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListCmekConfigs",
      requestType = com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest,
          com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>
      getListCmekConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest,
            com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>
        getListCmekConfigsMethod;
    if ((getListCmekConfigsMethod = CmekConfigServiceGrpc.getListCmekConfigsMethod) == null) {
      synchronized (CmekConfigServiceGrpc.class) {
        if ((getListCmekConfigsMethod = CmekConfigServiceGrpc.getListCmekConfigsMethod) == null) {
          CmekConfigServiceGrpc.getListCmekConfigsMethod =
              getListCmekConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest,
                          com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListCmekConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekConfigServiceMethodDescriptorSupplier("ListCmekConfigs"))
                      .build();
        }
      }
    }
    return getListCmekConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest,
          com.google.longrunning.Operation>
      getDeleteCmekConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteCmekConfig",
      requestType = com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest,
          com.google.longrunning.Operation>
      getDeleteCmekConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest,
            com.google.longrunning.Operation>
        getDeleteCmekConfigMethod;
    if ((getDeleteCmekConfigMethod = CmekConfigServiceGrpc.getDeleteCmekConfigMethod) == null) {
      synchronized (CmekConfigServiceGrpc.class) {
        if ((getDeleteCmekConfigMethod = CmekConfigServiceGrpc.getDeleteCmekConfigMethod) == null) {
          CmekConfigServiceGrpc.getDeleteCmekConfigMethod =
              getDeleteCmekConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteCmekConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new CmekConfigServiceMethodDescriptorSupplier("DeleteCmekConfig"))
                      .build();
        }
      }
    }
    return getDeleteCmekConfigMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static CmekConfigServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceStub>() {
          @java.lang.Override
          public CmekConfigServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekConfigServiceStub(channel, callOptions);
          }
        };
    return CmekConfigServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static CmekConfigServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceBlockingV2Stub>() {
          @java.lang.Override
          public CmekConfigServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekConfigServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return CmekConfigServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static CmekConfigServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceBlockingStub>() {
          @java.lang.Override
          public CmekConfigServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekConfigServiceBlockingStub(channel, callOptions);
          }
        };
    return CmekConfigServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static CmekConfigServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<CmekConfigServiceFutureStub>() {
          @java.lang.Override
          public CmekConfigServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new CmekConfigServiceFutureStub(channel, callOptions);
          }
        };
    return CmekConfigServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing CMEK related tasks
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Provisions a CMEK key for use in a location of a customer's project.
     * This method will also conduct location validation on the provided
     * cmekConfig to make sure the key is valid and can be used in the
     * selected location.
     * </pre>
     */
    default void updateCmekConfig(
        com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateCmekConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
     * </pre>
     */
    default void getCmekConfig(
        com.google.cloud.discoveryengine.v1.GetCmekConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.CmekConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetCmekConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s
     * with the project.
     * </pre>
     */
    default void listCmekConfigs(
        com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListCmekConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * De-provisions a CmekConfig.
     * </pre>
     */
    default void deleteCmekConfig(
        com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteCmekConfigMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service CmekConfigService.
   *
   * <pre>
   * Service for managing CMEK related tasks
   * </pre>
   */
  public abstract static class CmekConfigServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return CmekConfigServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service CmekConfigService.
   *
   * <pre>
   * Service for managing CMEK related tasks
   * </pre>
   */
  public static final class CmekConfigServiceStub
      extends io.grpc.stub.AbstractAsyncStub<CmekConfigServiceStub> {
    private CmekConfigServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekConfigServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekConfigServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provisions a CMEK key for use in a location of a customer's project.
     * This method will also conduct location validation on the provided
     * cmekConfig to make sure the key is valid and can be used in the
     * selected location.
     * </pre>
     */
    public void updateCmekConfig(
        com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateCmekConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
     * </pre>
     */
    public void getCmekConfig(
        com.google.cloud.discoveryengine.v1.GetCmekConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.CmekConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetCmekConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s
     * with the project.
     * </pre>
     */
    public void listCmekConfigs(
        com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListCmekConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * De-provisions a CmekConfig.
     * </pre>
     */
    public void deleteCmekConfig(
        com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteCmekConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service CmekConfigService.
   *
   * <pre>
   * Service for managing CMEK related tasks
   * </pre>
   */
  public static final class CmekConfigServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<CmekConfigServiceBlockingV2Stub> {
    private CmekConfigServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekConfigServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekConfigServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provisions a CMEK key for use in a location of a customer's project.
     * This method will also conduct location validation on the provided
     * cmekConfig to make sure the key is valid and can be used in the
     * selected location.
     * </pre>
     */
    public com.google.longrunning.Operation updateCmekConfig(
        com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCmekConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.CmekConfig getCmekConfig(
        com.google.cloud.discoveryengine.v1.GetCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCmekConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s
     * with the project.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse listCmekConfigs(
        com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCmekConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * De-provisions a CmekConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCmekConfig(
        com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCmekConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service CmekConfigService.
   *
   * <pre>
   * Service for managing CMEK related tasks
   * </pre>
   */
  public static final class CmekConfigServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<CmekConfigServiceBlockingStub> {
    private CmekConfigServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekConfigServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provisions a CMEK key for use in a location of a customer's project.
     * This method will also conduct location validation on the provided
     * cmekConfig to make sure the key is valid and can be used in the
     * selected location.
     * </pre>
     */
    public com.google.longrunning.Operation updateCmekConfig(
        com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateCmekConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.CmekConfig getCmekConfig(
        com.google.cloud.discoveryengine.v1.GetCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetCmekConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s
     * with the project.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse listCmekConfigs(
        com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListCmekConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * De-provisions a CmekConfig.
     * </pre>
     */
    public com.google.longrunning.Operation deleteCmekConfig(
        com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteCmekConfigMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service CmekConfigService.
   *
   * <pre>
   * Service for managing CMEK related tasks
   * </pre>
   */
  public static final class CmekConfigServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<CmekConfigServiceFutureStub> {
    private CmekConfigServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected CmekConfigServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new CmekConfigServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Provisions a CMEK key for use in a location of a customer's project.
     * This method will also conduct location validation on the provided
     * cmekConfig to make sure the key is valid and can be used in the
     * selected location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        updateCmekConfig(com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateCmekConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.CmekConfig>
        getCmekConfig(com.google.cloud.discoveryengine.v1.GetCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetCmekConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all the [CmekConfig][google.cloud.discoveryengine.v1.CmekConfig]s
     * with the project.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>
        listCmekConfigs(com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListCmekConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * De-provisions a CmekConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteCmekConfig(com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteCmekConfigMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_UPDATE_CMEK_CONFIG = 0;
  private static final int METHODID_GET_CMEK_CONFIG = 1;
  private static final int METHODID_LIST_CMEK_CONFIGS = 2;
  private static final int METHODID_DELETE_CMEK_CONFIG = 3;

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
        case METHODID_UPDATE_CMEK_CONFIG:
          serviceImpl.updateCmekConfig(
              (com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_GET_CMEK_CONFIG:
          serviceImpl.getCmekConfig(
              (com.google.cloud.discoveryengine.v1.GetCmekConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1.CmekConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_CMEK_CONFIGS:
          serviceImpl.listCmekConfigs(
              (com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_DELETE_CMEK_CONFIG:
          serviceImpl.deleteCmekConfig(
              (com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest) request,
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
            getUpdateCmekConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.UpdateCmekConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_UPDATE_CMEK_CONFIG)))
        .addMethod(
            getGetCmekConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.GetCmekConfigRequest,
                    com.google.cloud.discoveryengine.v1.CmekConfig>(
                    service, METHODID_GET_CMEK_CONFIG)))
        .addMethod(
            getListCmekConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.ListCmekConfigsRequest,
                    com.google.cloud.discoveryengine.v1.ListCmekConfigsResponse>(
                    service, METHODID_LIST_CMEK_CONFIGS)))
        .addMethod(
            getDeleteCmekConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1.DeleteCmekConfigRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_CMEK_CONFIG)))
        .build();
  }

  private abstract static class CmekConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    CmekConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1.CmekConfigServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("CmekConfigService");
    }
  }

  private static final class CmekConfigServiceFileDescriptorSupplier
      extends CmekConfigServiceBaseDescriptorSupplier {
    CmekConfigServiceFileDescriptorSupplier() {}
  }

  private static final class CmekConfigServiceMethodDescriptorSupplier
      extends CmekConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    CmekConfigServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (CmekConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new CmekConfigServiceFileDescriptorSupplier())
                      .addMethod(getUpdateCmekConfigMethod())
                      .addMethod(getGetCmekConfigMethod())
                      .addMethod(getListCmekConfigsMethod())
                      .addMethod(getDeleteCmekConfigMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
