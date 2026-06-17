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
package com.google.cloud.discoveryengine.v1beta;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for operations related to
 * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig].
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class ServingConfigServiceGrpc {

  private ServingConfigServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.discoveryengine.v1beta.ServingConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest,
          com.google.cloud.discoveryengine.v1beta.ServingConfig>
      getCreateServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServingConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest,
          com.google.cloud.discoveryengine.v1beta.ServingConfig>
      getCreateServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest,
            com.google.cloud.discoveryengine.v1beta.ServingConfig>
        getCreateServingConfigMethod;
    if ((getCreateServingConfigMethod = ServingConfigServiceGrpc.getCreateServingConfigMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getCreateServingConfigMethod = ServingConfigServiceGrpc.getCreateServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getCreateServingConfigMethod =
              getCreateServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ServingConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("CreateServingConfig"))
                      .build();
        }
      }
    }
    return getCreateServingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest,
          com.google.protobuf.Empty>
      getDeleteServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServingConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest,
          com.google.protobuf.Empty>
      getDeleteServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest,
            com.google.protobuf.Empty>
        getDeleteServingConfigMethod;
    if ((getDeleteServingConfigMethod = ServingConfigServiceGrpc.getDeleteServingConfigMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getDeleteServingConfigMethod = ServingConfigServiceGrpc.getDeleteServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getDeleteServingConfigMethod =
              getDeleteServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("DeleteServingConfig"))
                      .build();
        }
      }
    }
    return getDeleteServingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest,
          com.google.cloud.discoveryengine.v1beta.ServingConfig>
      getUpdateServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServingConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest,
          com.google.cloud.discoveryengine.v1beta.ServingConfig>
      getUpdateServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest,
            com.google.cloud.discoveryengine.v1beta.ServingConfig>
        getUpdateServingConfigMethod;
    if ((getUpdateServingConfigMethod = ServingConfigServiceGrpc.getUpdateServingConfigMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getUpdateServingConfigMethod = ServingConfigServiceGrpc.getUpdateServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getUpdateServingConfigMethod =
              getUpdateServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ServingConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("UpdateServingConfig"))
                      .build();
        }
      }
    }
    return getUpdateServingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest,
          com.google.cloud.discoveryengine.v1beta.ServingConfig>
      getGetServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServingConfig",
      requestType = com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest,
          com.google.cloud.discoveryengine.v1beta.ServingConfig>
      getGetServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest,
            com.google.cloud.discoveryengine.v1beta.ServingConfig>
        getGetServingConfigMethod;
    if ((getGetServingConfigMethod = ServingConfigServiceGrpc.getGetServingConfigMethod) == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getGetServingConfigMethod = ServingConfigServiceGrpc.getGetServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getGetServingConfigMethod =
              getGetServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest,
                          com.google.cloud.discoveryengine.v1beta.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ServingConfig
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("GetServingConfig"))
                      .build();
        }
      }
    }
    return getGetServingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest,
          com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>
      getListServingConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServingConfigs",
      requestType = com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest.class,
      responseType = com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest,
          com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>
      getListServingConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest,
            com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>
        getListServingConfigsMethod;
    if ((getListServingConfigsMethod = ServingConfigServiceGrpc.getListServingConfigsMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getListServingConfigsMethod = ServingConfigServiceGrpc.getListServingConfigsMethod)
            == null) {
          ServingConfigServiceGrpc.getListServingConfigsMethod =
              getListServingConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest,
                          com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServingConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("ListServingConfigs"))
                      .build();
        }
      }
    }
    return getListServingConfigsMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static ServingConfigServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceStub>() {
          @java.lang.Override
          public ServingConfigServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServingConfigServiceStub(channel, callOptions);
          }
        };
    return ServingConfigServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static ServingConfigServiceBlockingV2Stub newBlockingV2Stub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceBlockingV2Stub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceBlockingV2Stub>() {
          @java.lang.Override
          public ServingConfigServiceBlockingV2Stub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServingConfigServiceBlockingV2Stub(channel, callOptions);
          }
        };
    return ServingConfigServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServingConfigServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceBlockingStub>() {
          @java.lang.Override
          public ServingConfigServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServingConfigServiceBlockingStub(channel, callOptions);
          }
        };
    return ServingConfigServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static ServingConfigServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<ServingConfigServiceFutureStub>() {
          @java.lang.Override
          public ServingConfigServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new ServingConfigServiceFutureStub(channel, callOptions);
          }
        };
    return ServingConfigServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for operations related to
   * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Creates a ServingConfig.
     * Note: The Google Cloud console works only with the default serving config.
     * Additional ServingConfigs can be created and managed only via the API.
     * A maximum of 100
     * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig]s are
     * allowed in an [Engine][google.cloud.discoveryengine.v1beta.Engine],
     * otherwise a RESOURCE_EXHAUSTED error is returned.
     * </pre>
     */
    default void createServingConfig(
        com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    default void deleteServingConfig(
        com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    default void updateServingConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateServingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    default void getServingConfig(
        com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this dataStore.
     * </pre>
     */
    default void listServingConfigs(
        com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServingConfigsMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ServingConfigService.
   *
   * <pre>
   * Service for operations related to
   * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig].
   * </pre>
   */
  public abstract static class ServingConfigServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return ServingConfigServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ServingConfigService.
   *
   * <pre>
   * Service for operations related to
   * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig].
   * </pre>
   */
  public static final class ServingConfigServiceStub
      extends io.grpc.stub.AbstractAsyncStub<ServingConfigServiceStub> {
    private ServingConfigServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServingConfigServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServingConfigServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ServingConfig.
     * Note: The Google Cloud console works only with the default serving config.
     * Additional ServingConfigs can be created and managed only via the API.
     * A maximum of 100
     * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig]s are
     * allowed in an [Engine][google.cloud.discoveryengine.v1beta.Engine],
     * otherwise a RESOURCE_EXHAUSTED error is returned.
     * </pre>
     */
    public void createServingConfig(
        com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateServingConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public void deleteServingConfig(
        com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteServingConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public void updateServingConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateServingConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public void getServingConfig(
        com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServingConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this dataStore.
     * </pre>
     */
    public void listServingConfigs(
        com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServingConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ServingConfigService.
   *
   * <pre>
   * Service for operations related to
   * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig].
   * </pre>
   */
  public static final class ServingConfigServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ServingConfigServiceBlockingV2Stub> {
    private ServingConfigServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServingConfigServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServingConfigServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ServingConfig.
     * Note: The Google Cloud console works only with the default serving config.
     * Additional ServingConfigs can be created and managed only via the API.
     * A maximum of 100
     * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig]s are
     * allowed in an [Engine][google.cloud.discoveryengine.v1beta.Engine],
     * otherwise a RESOURCE_EXHAUSTED error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ServingConfig createServingConfig(
        com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getCreateServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteServingConfig(
        com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getDeleteServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ServingConfig updateServingConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getUpdateServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ServingConfig getServingConfig(
        com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this dataStore.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse listServingConfigs(
        com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest request)
        throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListServingConfigsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ServingConfigService.
   *
   * <pre>
   * Service for operations related to
   * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig].
   * </pre>
   */
  public static final class ServingConfigServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ServingConfigServiceBlockingStub> {
    private ServingConfigServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServingConfigServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServingConfigServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ServingConfig.
     * Note: The Google Cloud console works only with the default serving config.
     * Additional ServingConfigs can be created and managed only via the API.
     * A maximum of 100
     * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig]s are
     * allowed in an [Engine][google.cloud.discoveryengine.v1beta.Engine],
     * otherwise a RESOURCE_EXHAUSTED error is returned.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ServingConfig createServingConfig(
        com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteServingConfig(
        com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ServingConfig updateServingConfig(
        com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ServingConfig getServingConfig(
        com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this dataStore.
     * </pre>
     */
    public com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse listServingConfigs(
        com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServingConfigsMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ServingConfigService.
   *
   * <pre>
   * Service for operations related to
   * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig].
   * </pre>
   */
  public static final class ServingConfigServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<ServingConfigServiceFutureStub> {
    private ServingConfigServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServingConfigServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServingConfigServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Creates a ServingConfig.
     * Note: The Google Cloud console works only with the default serving config.
     * Additional ServingConfigs can be created and managed only via the API.
     * A maximum of 100
     * [ServingConfig][google.cloud.discoveryengine.v1beta.ServingConfig]s are
     * allowed in an [Engine][google.cloud.discoveryengine.v1beta.Engine],
     * otherwise a RESOURCE_EXHAUSTED error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ServingConfig>
        createServingConfig(
            com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteServingConfig(
            com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * Returns a NOT_FOUND error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ServingConfig>
        updateServingConfig(
            com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateServingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ServingConfig>
        getServingConfig(com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this dataStore.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>
        listServingConfigs(
            com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServingConfigsMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SERVING_CONFIG = 0;
  private static final int METHODID_DELETE_SERVING_CONFIG = 1;
  private static final int METHODID_UPDATE_SERVING_CONFIG = 2;
  private static final int METHODID_GET_SERVING_CONFIG = 3;
  private static final int METHODID_LIST_SERVING_CONFIGS = 4;

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
        case METHODID_CREATE_SERVING_CONFIG:
          serviceImpl.createServingConfig(
              (com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_SERVING_CONFIG:
          serviceImpl.deleteServingConfig(
              (com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_SERVING_CONFIG:
          serviceImpl.updateServingConfig(
              (com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>)
                  responseObserver);
          break;
        case METHODID_GET_SERVING_CONFIG:
          serviceImpl.getServingConfig(
              (com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.discoveryengine.v1beta.ServingConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVING_CONFIGS:
          serviceImpl.listServingConfigs(
              (com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>)
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
            getCreateServingConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.CreateServingConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.ServingConfig>(
                    service, METHODID_CREATE_SERVING_CONFIG)))
        .addMethod(
            getDeleteServingConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.DeleteServingConfigRequest,
                    com.google.protobuf.Empty>(service, METHODID_DELETE_SERVING_CONFIG)))
        .addMethod(
            getUpdateServingConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.UpdateServingConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.ServingConfig>(
                    service, METHODID_UPDATE_SERVING_CONFIG)))
        .addMethod(
            getGetServingConfigMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.GetServingConfigRequest,
                    com.google.cloud.discoveryengine.v1beta.ServingConfig>(
                    service, METHODID_GET_SERVING_CONFIG)))
        .addMethod(
            getListServingConfigsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.discoveryengine.v1beta.ListServingConfigsRequest,
                    com.google.cloud.discoveryengine.v1beta.ListServingConfigsResponse>(
                    service, METHODID_LIST_SERVING_CONFIGS)))
        .build();
  }

  private abstract static class ServingConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServingConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.discoveryengine.v1beta.ServingConfigServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ServingConfigService");
    }
  }

  private static final class ServingConfigServiceFileDescriptorSupplier
      extends ServingConfigServiceBaseDescriptorSupplier {
    ServingConfigServiceFileDescriptorSupplier() {}
  }

  private static final class ServingConfigServiceMethodDescriptorSupplier
      extends ServingConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ServingConfigServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (ServingConfigServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new ServingConfigServiceFileDescriptorSupplier())
                      .addMethod(getCreateServingConfigMethod())
                      .addMethod(getDeleteServingConfigMethod())
                      .addMethod(getUpdateServingConfigMethod())
                      .addMethod(getGetServingConfigMethod())
                      .addMethod(getListServingConfigsMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
