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
package com.google.cloud.retail.v2;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Service for modifying ServingConfig.
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/retail/v2/serving_config_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ServingConfigServiceGrpc {

  private ServingConfigServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.retail.v2.ServingConfigService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.CreateServingConfigRequest,
          com.google.cloud.retail.v2.ServingConfig>
      getCreateServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateServingConfig",
      requestType = com.google.cloud.retail.v2.CreateServingConfigRequest.class,
      responseType = com.google.cloud.retail.v2.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.CreateServingConfigRequest,
          com.google.cloud.retail.v2.ServingConfig>
      getCreateServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.CreateServingConfigRequest,
            com.google.cloud.retail.v2.ServingConfig>
        getCreateServingConfigMethod;
    if ((getCreateServingConfigMethod = ServingConfigServiceGrpc.getCreateServingConfigMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getCreateServingConfigMethod = ServingConfigServiceGrpc.getCreateServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getCreateServingConfigMethod =
              getCreateServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.CreateServingConfigRequest,
                          com.google.cloud.retail.v2.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.CreateServingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ServingConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("CreateServingConfig"))
                      .build();
        }
      }
    }
    return getCreateServingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.DeleteServingConfigRequest, com.google.protobuf.Empty>
      getDeleteServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteServingConfig",
      requestType = com.google.cloud.retail.v2.DeleteServingConfigRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.DeleteServingConfigRequest, com.google.protobuf.Empty>
      getDeleteServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.DeleteServingConfigRequest, com.google.protobuf.Empty>
        getDeleteServingConfigMethod;
    if ((getDeleteServingConfigMethod = ServingConfigServiceGrpc.getDeleteServingConfigMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getDeleteServingConfigMethod = ServingConfigServiceGrpc.getDeleteServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getDeleteServingConfigMethod =
              getDeleteServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.DeleteServingConfigRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.DeleteServingConfigRequest
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
          com.google.cloud.retail.v2.UpdateServingConfigRequest,
          com.google.cloud.retail.v2.ServingConfig>
      getUpdateServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateServingConfig",
      requestType = com.google.cloud.retail.v2.UpdateServingConfigRequest.class,
      responseType = com.google.cloud.retail.v2.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.UpdateServingConfigRequest,
          com.google.cloud.retail.v2.ServingConfig>
      getUpdateServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.UpdateServingConfigRequest,
            com.google.cloud.retail.v2.ServingConfig>
        getUpdateServingConfigMethod;
    if ((getUpdateServingConfigMethod = ServingConfigServiceGrpc.getUpdateServingConfigMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getUpdateServingConfigMethod = ServingConfigServiceGrpc.getUpdateServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getUpdateServingConfigMethod =
              getUpdateServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.UpdateServingConfigRequest,
                          com.google.cloud.retail.v2.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.UpdateServingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ServingConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("UpdateServingConfig"))
                      .build();
        }
      }
    }
    return getUpdateServingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.GetServingConfigRequest,
          com.google.cloud.retail.v2.ServingConfig>
      getGetServingConfigMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetServingConfig",
      requestType = com.google.cloud.retail.v2.GetServingConfigRequest.class,
      responseType = com.google.cloud.retail.v2.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.GetServingConfigRequest,
          com.google.cloud.retail.v2.ServingConfig>
      getGetServingConfigMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.GetServingConfigRequest,
            com.google.cloud.retail.v2.ServingConfig>
        getGetServingConfigMethod;
    if ((getGetServingConfigMethod = ServingConfigServiceGrpc.getGetServingConfigMethod) == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getGetServingConfigMethod = ServingConfigServiceGrpc.getGetServingConfigMethod)
            == null) {
          ServingConfigServiceGrpc.getGetServingConfigMethod =
              getGetServingConfigMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.GetServingConfigRequest,
                          com.google.cloud.retail.v2.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetServingConfig"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.GetServingConfigRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ServingConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("GetServingConfig"))
                      .build();
        }
      }
    }
    return getGetServingConfigMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ListServingConfigsRequest,
          com.google.cloud.retail.v2.ListServingConfigsResponse>
      getListServingConfigsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListServingConfigs",
      requestType = com.google.cloud.retail.v2.ListServingConfigsRequest.class,
      responseType = com.google.cloud.retail.v2.ListServingConfigsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.ListServingConfigsRequest,
          com.google.cloud.retail.v2.ListServingConfigsResponse>
      getListServingConfigsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.ListServingConfigsRequest,
            com.google.cloud.retail.v2.ListServingConfigsResponse>
        getListServingConfigsMethod;
    if ((getListServingConfigsMethod = ServingConfigServiceGrpc.getListServingConfigsMethod)
        == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getListServingConfigsMethod = ServingConfigServiceGrpc.getListServingConfigsMethod)
            == null) {
          ServingConfigServiceGrpc.getListServingConfigsMethod =
              getListServingConfigsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.ListServingConfigsRequest,
                          com.google.cloud.retail.v2.ListServingConfigsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListServingConfigs"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ListServingConfigsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ListServingConfigsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("ListServingConfigs"))
                      .build();
        }
      }
    }
    return getListServingConfigsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.AddControlRequest, com.google.cloud.retail.v2.ServingConfig>
      getAddControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddControl",
      requestType = com.google.cloud.retail.v2.AddControlRequest.class,
      responseType = com.google.cloud.retail.v2.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.AddControlRequest, com.google.cloud.retail.v2.ServingConfig>
      getAddControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.AddControlRequest, com.google.cloud.retail.v2.ServingConfig>
        getAddControlMethod;
    if ((getAddControlMethod = ServingConfigServiceGrpc.getAddControlMethod) == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getAddControlMethod = ServingConfigServiceGrpc.getAddControlMethod) == null) {
          ServingConfigServiceGrpc.getAddControlMethod =
              getAddControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.AddControlRequest,
                          com.google.cloud.retail.v2.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.AddControlRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ServingConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("AddControl"))
                      .build();
        }
      }
    }
    return getAddControlMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.RemoveControlRequest, com.google.cloud.retail.v2.ServingConfig>
      getRemoveControlMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "RemoveControl",
      requestType = com.google.cloud.retail.v2.RemoveControlRequest.class,
      responseType = com.google.cloud.retail.v2.ServingConfig.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.retail.v2.RemoveControlRequest, com.google.cloud.retail.v2.ServingConfig>
      getRemoveControlMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.retail.v2.RemoveControlRequest,
            com.google.cloud.retail.v2.ServingConfig>
        getRemoveControlMethod;
    if ((getRemoveControlMethod = ServingConfigServiceGrpc.getRemoveControlMethod) == null) {
      synchronized (ServingConfigServiceGrpc.class) {
        if ((getRemoveControlMethod = ServingConfigServiceGrpc.getRemoveControlMethod) == null) {
          ServingConfigServiceGrpc.getRemoveControlMethod =
              getRemoveControlMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.retail.v2.RemoveControlRequest,
                          com.google.cloud.retail.v2.ServingConfig>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "RemoveControl"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.RemoveControlRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.retail.v2.ServingConfig.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new ServingConfigServiceMethodDescriptorSupplier("RemoveControl"))
                      .build();
        }
      }
    }
    return getRemoveControlMethod;
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
   * Service for modifying ServingConfig.
   * </pre>
   */
  public abstract static class ServingConfigServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Creates a ServingConfig.
     * A maximum of 100 [ServingConfig][google.cloud.retail.v2.ServingConfig]s are
     * allowed in a [Catalog][google.cloud.retail.v2.Catalog], otherwise a
     * FAILED_PRECONDITION error is returned.
     * </pre>
     */
    public void createServingConfig(
        com.google.cloud.retail.v2.CreateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateServingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public void deleteServingConfig(
        com.google.cloud.retail.v2.DeleteServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteServingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * </pre>
     */
    public void updateServingConfig(
        com.google.cloud.retail.v2.UpdateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
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
    public void getServingConfig(
        com.google.cloud.retail.v2.GetServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetServingConfigMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this catalog.
     * </pre>
     */
    public void listServingConfigs(
        com.google.cloud.retail.v2.ListServingConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ListServingConfigsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListServingConfigsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a Control on the specified ServingConfig.
     * The control is added in the last position of the list of controls
     * it belongs to (e.g. if it's a facet spec control it will be applied
     * in the last position of servingConfig.facetSpecIds)
     * Returns a ALREADY_EXISTS error if the control has already been applied.
     * Returns a FAILED_PRECONDITION error if the addition could exceed maximum
     * number of control allowed for that type of control.
     * </pre>
     */
    public void addControl(
        com.google.cloud.retail.v2.AddControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddControlMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a Control on the specified ServingConfig.
     * The control is removed from the ServingConfig.
     * Returns a NOT_FOUND error if the Control is not enabled for the
     * ServingConfig.
     * </pre>
     */
    public void removeControl(
        com.google.cloud.retail.v2.RemoveControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getRemoveControlMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getCreateServingConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.CreateServingConfigRequest,
                      com.google.cloud.retail.v2.ServingConfig>(
                      this, METHODID_CREATE_SERVING_CONFIG)))
          .addMethod(
              getDeleteServingConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.DeleteServingConfigRequest,
                      com.google.protobuf.Empty>(this, METHODID_DELETE_SERVING_CONFIG)))
          .addMethod(
              getUpdateServingConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.UpdateServingConfigRequest,
                      com.google.cloud.retail.v2.ServingConfig>(
                      this, METHODID_UPDATE_SERVING_CONFIG)))
          .addMethod(
              getGetServingConfigMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.GetServingConfigRequest,
                      com.google.cloud.retail.v2.ServingConfig>(this, METHODID_GET_SERVING_CONFIG)))
          .addMethod(
              getListServingConfigsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.ListServingConfigsRequest,
                      com.google.cloud.retail.v2.ListServingConfigsResponse>(
                      this, METHODID_LIST_SERVING_CONFIGS)))
          .addMethod(
              getAddControlMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.AddControlRequest,
                      com.google.cloud.retail.v2.ServingConfig>(this, METHODID_ADD_CONTROL)))
          .addMethod(
              getRemoveControlMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.retail.v2.RemoveControlRequest,
                      com.google.cloud.retail.v2.ServingConfig>(this, METHODID_REMOVE_CONTROL)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Service for modifying ServingConfig.
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
     * A maximum of 100 [ServingConfig][google.cloud.retail.v2.ServingConfig]s are
     * allowed in a [Catalog][google.cloud.retail.v2.Catalog], otherwise a
     * FAILED_PRECONDITION error is returned.
     * </pre>
     */
    public void createServingConfig(
        com.google.cloud.retail.v2.CreateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
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
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public void deleteServingConfig(
        com.google.cloud.retail.v2.DeleteServingConfigRequest request,
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
     * </pre>
     */
    public void updateServingConfig(
        com.google.cloud.retail.v2.UpdateServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
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
        com.google.cloud.retail.v2.GetServingConfigRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetServingConfigMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this catalog.
     * </pre>
     */
    public void listServingConfigs(
        com.google.cloud.retail.v2.ListServingConfigsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ListServingConfigsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListServingConfigsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Enables a Control on the specified ServingConfig.
     * The control is added in the last position of the list of controls
     * it belongs to (e.g. if it's a facet spec control it will be applied
     * in the last position of servingConfig.facetSpecIds)
     * Returns a ALREADY_EXISTS error if the control has already been applied.
     * Returns a FAILED_PRECONDITION error if the addition could exceed maximum
     * number of control allowed for that type of control.
     * </pre>
     */
    public void addControl(
        com.google.cloud.retail.v2.AddControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddControlMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Disables a Control on the specified ServingConfig.
     * The control is removed from the ServingConfig.
     * Returns a NOT_FOUND error if the Control is not enabled for the
     * ServingConfig.
     * </pre>
     */
    public void removeControl(
        com.google.cloud.retail.v2.RemoveControlRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRemoveControlMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for modifying ServingConfig.
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
     * A maximum of 100 [ServingConfig][google.cloud.retail.v2.ServingConfig]s are
     * allowed in a [Catalog][google.cloud.retail.v2.Catalog], otherwise a
     * FAILED_PRECONDITION error is returned.
     * </pre>
     */
    public com.google.cloud.retail.v2.ServingConfig createServingConfig(
        com.google.cloud.retail.v2.CreateServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.protobuf.Empty deleteServingConfig(
        com.google.cloud.retail.v2.DeleteServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * </pre>
     */
    public com.google.cloud.retail.v2.ServingConfig updateServingConfig(
        com.google.cloud.retail.v2.UpdateServingConfigRequest request) {
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
    public com.google.cloud.retail.v2.ServingConfig getServingConfig(
        com.google.cloud.retail.v2.GetServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetServingConfigMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this catalog.
     * </pre>
     */
    public com.google.cloud.retail.v2.ListServingConfigsResponse listServingConfigs(
        com.google.cloud.retail.v2.ListServingConfigsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListServingConfigsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a Control on the specified ServingConfig.
     * The control is added in the last position of the list of controls
     * it belongs to (e.g. if it's a facet spec control it will be applied
     * in the last position of servingConfig.facetSpecIds)
     * Returns a ALREADY_EXISTS error if the control has already been applied.
     * Returns a FAILED_PRECONDITION error if the addition could exceed maximum
     * number of control allowed for that type of control.
     * </pre>
     */
    public com.google.cloud.retail.v2.ServingConfig addControl(
        com.google.cloud.retail.v2.AddControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddControlMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a Control on the specified ServingConfig.
     * The control is removed from the ServingConfig.
     * Returns a NOT_FOUND error if the Control is not enabled for the
     * ServingConfig.
     * </pre>
     */
    public com.google.cloud.retail.v2.ServingConfig removeControl(
        com.google.cloud.retail.v2.RemoveControlRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRemoveControlMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Service for modifying ServingConfig.
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
     * A maximum of 100 [ServingConfig][google.cloud.retail.v2.ServingConfig]s are
     * allowed in a [Catalog][google.cloud.retail.v2.Catalog], otherwise a
     * FAILED_PRECONDITION error is returned.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2.ServingConfig>
        createServingConfig(com.google.cloud.retail.v2.CreateServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateServingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a ServingConfig.
     * Returns a NotFound error if the ServingConfig does not exist.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteServingConfig(com.google.cloud.retail.v2.DeleteServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteServingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates a ServingConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2.ServingConfig>
        updateServingConfig(com.google.cloud.retail.v2.UpdateServingConfigRequest request) {
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
            com.google.cloud.retail.v2.ServingConfig>
        getServingConfig(com.google.cloud.retail.v2.GetServingConfigRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetServingConfigMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Lists all ServingConfigs linked to this catalog.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2.ListServingConfigsResponse>
        listServingConfigs(com.google.cloud.retail.v2.ListServingConfigsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListServingConfigsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Enables a Control on the specified ServingConfig.
     * The control is added in the last position of the list of controls
     * it belongs to (e.g. if it's a facet spec control it will be applied
     * in the last position of servingConfig.facetSpecIds)
     * Returns a ALREADY_EXISTS error if the control has already been applied.
     * Returns a FAILED_PRECONDITION error if the addition could exceed maximum
     * number of control allowed for that type of control.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2.ServingConfig>
        addControl(com.google.cloud.retail.v2.AddControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddControlMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Disables a Control on the specified ServingConfig.
     * The control is removed from the ServingConfig.
     * Returns a NOT_FOUND error if the Control is not enabled for the
     * ServingConfig.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.retail.v2.ServingConfig>
        removeControl(com.google.cloud.retail.v2.RemoveControlRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRemoveControlMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CREATE_SERVING_CONFIG = 0;
  private static final int METHODID_DELETE_SERVING_CONFIG = 1;
  private static final int METHODID_UPDATE_SERVING_CONFIG = 2;
  private static final int METHODID_GET_SERVING_CONFIG = 3;
  private static final int METHODID_LIST_SERVING_CONFIGS = 4;
  private static final int METHODID_ADD_CONTROL = 5;
  private static final int METHODID_REMOVE_CONTROL = 6;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ServingConfigServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServingConfigServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CREATE_SERVING_CONFIG:
          serviceImpl.createServingConfig(
              (com.google.cloud.retail.v2.CreateServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig>)
                  responseObserver);
          break;
        case METHODID_DELETE_SERVING_CONFIG:
          serviceImpl.deleteServingConfig(
              (com.google.cloud.retail.v2.DeleteServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
          break;
        case METHODID_UPDATE_SERVING_CONFIG:
          serviceImpl.updateServingConfig(
              (com.google.cloud.retail.v2.UpdateServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig>)
                  responseObserver);
          break;
        case METHODID_GET_SERVING_CONFIG:
          serviceImpl.getServingConfig(
              (com.google.cloud.retail.v2.GetServingConfigRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig>)
                  responseObserver);
          break;
        case METHODID_LIST_SERVING_CONFIGS:
          serviceImpl.listServingConfigs(
              (com.google.cloud.retail.v2.ListServingConfigsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ListServingConfigsResponse>)
                  responseObserver);
          break;
        case METHODID_ADD_CONTROL:
          serviceImpl.addControl(
              (com.google.cloud.retail.v2.AddControlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig>)
                  responseObserver);
          break;
        case METHODID_REMOVE_CONTROL:
          serviceImpl.removeControl(
              (com.google.cloud.retail.v2.RemoveControlRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.retail.v2.ServingConfig>)
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

  private abstract static class ServingConfigServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServingConfigServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.retail.v2.ServingConfigServiceProto.getDescriptor();
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
    private final String methodName;

    ServingConfigServiceMethodDescriptorSupplier(String methodName) {
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
                      .addMethod(getAddControlMethod())
                      .addMethod(getRemoveControlMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
