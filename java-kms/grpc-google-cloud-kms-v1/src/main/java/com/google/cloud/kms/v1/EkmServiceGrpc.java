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
package com.google.cloud.kms.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * Google Cloud Key Management EKM Service
 * Manages external cryptographic keys and operations using those keys.
 * Implements a REST model with the following objects:
 * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/kms/v1/ekm_service.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class EkmServiceGrpc {

  private EkmServiceGrpc() {}

  public static final String SERVICE_NAME = "google.cloud.kms.v1.EkmService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListEkmConnectionsRequest,
          com.google.cloud.kms.v1.ListEkmConnectionsResponse>
      getListEkmConnectionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListEkmConnections",
      requestType = com.google.cloud.kms.v1.ListEkmConnectionsRequest.class,
      responseType = com.google.cloud.kms.v1.ListEkmConnectionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.ListEkmConnectionsRequest,
          com.google.cloud.kms.v1.ListEkmConnectionsResponse>
      getListEkmConnectionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.ListEkmConnectionsRequest,
            com.google.cloud.kms.v1.ListEkmConnectionsResponse>
        getListEkmConnectionsMethod;
    if ((getListEkmConnectionsMethod = EkmServiceGrpc.getListEkmConnectionsMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getListEkmConnectionsMethod = EkmServiceGrpc.getListEkmConnectionsMethod) == null) {
          EkmServiceGrpc.getListEkmConnectionsMethod =
              getListEkmConnectionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.ListEkmConnectionsRequest,
                          com.google.cloud.kms.v1.ListEkmConnectionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListEkmConnections"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListEkmConnectionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.ListEkmConnectionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EkmServiceMethodDescriptorSupplier("ListEkmConnections"))
                      .build();
        }
      }
    }
    return getListEkmConnectionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>
      getGetEkmConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetEkmConnection",
      requestType = com.google.cloud.kms.v1.GetEkmConnectionRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.GetEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>
      getGetEkmConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.GetEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>
        getGetEkmConnectionMethod;
    if ((getGetEkmConnectionMethod = EkmServiceGrpc.getGetEkmConnectionMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getGetEkmConnectionMethod = EkmServiceGrpc.getGetEkmConnectionMethod) == null) {
          EkmServiceGrpc.getGetEkmConnectionMethod =
              getGetEkmConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.GetEkmConnectionRequest,
                          com.google.cloud.kms.v1.EkmConnection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetEkmConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.GetEkmConnectionRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.EkmConnection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EkmServiceMethodDescriptorSupplier("GetEkmConnection"))
                      .build();
        }
      }
    }
    return getGetEkmConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>
      getCreateEkmConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateEkmConnection",
      requestType = com.google.cloud.kms.v1.CreateEkmConnectionRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.CreateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>
      getCreateEkmConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.CreateEkmConnectionRequest,
            com.google.cloud.kms.v1.EkmConnection>
        getCreateEkmConnectionMethod;
    if ((getCreateEkmConnectionMethod = EkmServiceGrpc.getCreateEkmConnectionMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getCreateEkmConnectionMethod = EkmServiceGrpc.getCreateEkmConnectionMethod) == null) {
          EkmServiceGrpc.getCreateEkmConnectionMethod =
              getCreateEkmConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.CreateEkmConnectionRequest,
                          com.google.cloud.kms.v1.EkmConnection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateEkmConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.CreateEkmConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.EkmConnection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EkmServiceMethodDescriptorSupplier("CreateEkmConnection"))
                      .build();
        }
      }
    }
    return getCreateEkmConnectionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>
      getUpdateEkmConnectionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateEkmConnection",
      requestType = com.google.cloud.kms.v1.UpdateEkmConnectionRequest.class,
      responseType = com.google.cloud.kms.v1.EkmConnection.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.kms.v1.UpdateEkmConnectionRequest, com.google.cloud.kms.v1.EkmConnection>
      getUpdateEkmConnectionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.kms.v1.UpdateEkmConnectionRequest,
            com.google.cloud.kms.v1.EkmConnection>
        getUpdateEkmConnectionMethod;
    if ((getUpdateEkmConnectionMethod = EkmServiceGrpc.getUpdateEkmConnectionMethod) == null) {
      synchronized (EkmServiceGrpc.class) {
        if ((getUpdateEkmConnectionMethod = EkmServiceGrpc.getUpdateEkmConnectionMethod) == null) {
          EkmServiceGrpc.getUpdateEkmConnectionMethod =
              getUpdateEkmConnectionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.kms.v1.UpdateEkmConnectionRequest,
                          com.google.cloud.kms.v1.EkmConnection>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "UpdateEkmConnection"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.UpdateEkmConnectionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.kms.v1.EkmConnection.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new EkmServiceMethodDescriptorSupplier("UpdateEkmConnection"))
                      .build();
        }
      }
    }
    return getUpdateEkmConnectionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static EkmServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EkmServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EkmServiceStub>() {
          @java.lang.Override
          public EkmServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EkmServiceStub(channel, callOptions);
          }
        };
    return EkmServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static EkmServiceBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EkmServiceBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EkmServiceBlockingStub>() {
          @java.lang.Override
          public EkmServiceBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EkmServiceBlockingStub(channel, callOptions);
          }
        };
    return EkmServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static EkmServiceFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<EkmServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<EkmServiceFutureStub>() {
          @java.lang.Override
          public EkmServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new EkmServiceFutureStub(channel, callOptions);
          }
        };
    return EkmServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public abstract static class EkmServiceImplBase implements io.grpc.BindableService {

    /**
     *
     *
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public void listEkmConnections(
        com.google.cloud.kms.v1.ListEkmConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListEkmConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListEkmConnectionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public void getEkmConnection(
        com.google.cloud.kms.v1.GetEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetEkmConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    public void createEkmConnection(
        com.google.cloud.kms.v1.CreateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateEkmConnectionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    public void updateEkmConnection(
        com.google.cloud.kms.v1.UpdateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateEkmConnectionMethod(), responseObserver);
    }

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
              getListEkmConnectionsMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.ListEkmConnectionsRequest,
                      com.google.cloud.kms.v1.ListEkmConnectionsResponse>(
                      this, METHODID_LIST_EKM_CONNECTIONS)))
          .addMethod(
              getGetEkmConnectionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.GetEkmConnectionRequest,
                      com.google.cloud.kms.v1.EkmConnection>(this, METHODID_GET_EKM_CONNECTION)))
          .addMethod(
              getCreateEkmConnectionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.CreateEkmConnectionRequest,
                      com.google.cloud.kms.v1.EkmConnection>(this, METHODID_CREATE_EKM_CONNECTION)))
          .addMethod(
              getUpdateEkmConnectionMethod(),
              io.grpc.stub.ServerCalls.asyncUnaryCall(
                  new MethodHandlers<
                      com.google.cloud.kms.v1.UpdateEkmConnectionRequest,
                      com.google.cloud.kms.v1.EkmConnection>(this, METHODID_UPDATE_EKM_CONNECTION)))
          .build();
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public static final class EkmServiceStub extends io.grpc.stub.AbstractAsyncStub<EkmServiceStub> {
    private EkmServiceStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EkmServiceStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EkmServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public void listEkmConnections(
        com.google.cloud.kms.v1.ListEkmConnectionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListEkmConnectionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListEkmConnectionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public void getEkmConnection(
        com.google.cloud.kms.v1.GetEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetEkmConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    public void createEkmConnection(
        com.google.cloud.kms.v1.CreateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateEkmConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    public void updateEkmConnection(
        com.google.cloud.kms.v1.UpdateEkmConnectionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateEkmConnectionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public static final class EkmServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<EkmServiceBlockingStub> {
    private EkmServiceBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EkmServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EkmServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.cloud.kms.v1.ListEkmConnectionsResponse listEkmConnections(
        com.google.cloud.kms.v1.ListEkmConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListEkmConnectionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConnection getEkmConnection(
        com.google.cloud.kms.v1.GetEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetEkmConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConnection createEkmConnection(
        com.google.cloud.kms.v1.CreateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateEkmConnectionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    public com.google.cloud.kms.v1.EkmConnection updateEkmConnection(
        com.google.cloud.kms.v1.UpdateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateEkmConnectionMethod(), getCallOptions(), request);
    }
  }

  /**
   *
   *
   * <pre>
   * Google Cloud Key Management EKM Service
   * Manages external cryptographic keys and operations using those keys.
   * Implements a REST model with the following objects:
   * * [EkmConnection][google.cloud.kms.v1.EkmConnection]
   * </pre>
   */
  public static final class EkmServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<EkmServiceFutureStub> {
    private EkmServiceFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected EkmServiceFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new EkmServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists [EkmConnections][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.kms.v1.ListEkmConnectionsResponse>
        listEkmConnections(com.google.cloud.kms.v1.ListEkmConnectionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListEkmConnectionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Returns metadata for a given
     * [EkmConnection][google.cloud.kms.v1.EkmConnection].
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConnection>
        getEkmConnection(com.google.cloud.kms.v1.GetEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetEkmConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new [EkmConnection][google.cloud.kms.v1.EkmConnection] in a given
     * Project and Location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConnection>
        createEkmConnection(com.google.cloud.kms.v1.CreateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateEkmConnectionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates an [EkmConnection][google.cloud.kms.v1.EkmConnection]'s metadata.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.cloud.kms.v1.EkmConnection>
        updateEkmConnection(com.google.cloud.kms.v1.UpdateEkmConnectionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateEkmConnectionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_EKM_CONNECTIONS = 0;
  private static final int METHODID_GET_EKM_CONNECTION = 1;
  private static final int METHODID_CREATE_EKM_CONNECTION = 2;
  private static final int METHODID_UPDATE_EKM_CONNECTION = 3;

  private static final class MethodHandlers<Req, Resp>
      implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
          io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final EkmServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(EkmServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_LIST_EKM_CONNECTIONS:
          serviceImpl.listEkmConnections(
              (com.google.cloud.kms.v1.ListEkmConnectionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.ListEkmConnectionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_EKM_CONNECTION:
          serviceImpl.getEkmConnection(
              (com.google.cloud.kms.v1.GetEkmConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection>)
                  responseObserver);
          break;
        case METHODID_CREATE_EKM_CONNECTION:
          serviceImpl.createEkmConnection(
              (com.google.cloud.kms.v1.CreateEkmConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection>)
                  responseObserver);
          break;
        case METHODID_UPDATE_EKM_CONNECTION:
          serviceImpl.updateEkmConnection(
              (com.google.cloud.kms.v1.UpdateEkmConnectionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.kms.v1.EkmConnection>)
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

  private abstract static class EkmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    EkmServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.kms.v1.EkmServiceProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("EkmService");
    }
  }

  private static final class EkmServiceFileDescriptorSupplier
      extends EkmServiceBaseDescriptorSupplier {
    EkmServiceFileDescriptorSupplier() {}
  }

  private static final class EkmServiceMethodDescriptorSupplier
      extends EkmServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    EkmServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (EkmServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new EkmServiceFileDescriptorSupplier())
                      .addMethod(getListEkmConnectionsMethod())
                      .addMethod(getGetEkmConnectionMethod())
                      .addMethod(getCreateEkmConnectionMethod())
                      .addMethod(getUpdateEkmConnectionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
