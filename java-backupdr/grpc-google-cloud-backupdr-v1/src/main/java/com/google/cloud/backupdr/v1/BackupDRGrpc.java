/*
 * Copyright 2024 Google LLC
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
package com.google.cloud.backupdr.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * The BackupDR Service
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/backupdr/v1/backupdr.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BackupDRGrpc {

  private BackupDRGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.backupdr.v1.BackupDR";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListManagementServersRequest,
          com.google.cloud.backupdr.v1.ListManagementServersResponse>
      getListManagementServersMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListManagementServers",
      requestType = com.google.cloud.backupdr.v1.ListManagementServersRequest.class,
      responseType = com.google.cloud.backupdr.v1.ListManagementServersResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.ListManagementServersRequest,
          com.google.cloud.backupdr.v1.ListManagementServersResponse>
      getListManagementServersMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.ListManagementServersRequest,
            com.google.cloud.backupdr.v1.ListManagementServersResponse>
        getListManagementServersMethod;
    if ((getListManagementServersMethod = BackupDRGrpc.getListManagementServersMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getListManagementServersMethod = BackupDRGrpc.getListManagementServersMethod)
            == null) {
          BackupDRGrpc.getListManagementServersMethod =
              getListManagementServersMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.ListManagementServersRequest,
                          com.google.cloud.backupdr.v1.ListManagementServersResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "ListManagementServers"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListManagementServersRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ListManagementServersResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("ListManagementServers"))
                      .build();
        }
      }
    }
    return getListManagementServersMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetManagementServerRequest,
          com.google.cloud.backupdr.v1.ManagementServer>
      getGetManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetManagementServer",
      requestType = com.google.cloud.backupdr.v1.GetManagementServerRequest.class,
      responseType = com.google.cloud.backupdr.v1.ManagementServer.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.GetManagementServerRequest,
          com.google.cloud.backupdr.v1.ManagementServer>
      getGetManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.GetManagementServerRequest,
            com.google.cloud.backupdr.v1.ManagementServer>
        getGetManagementServerMethod;
    if ((getGetManagementServerMethod = BackupDRGrpc.getGetManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getGetManagementServerMethod = BackupDRGrpc.getGetManagementServerMethod) == null) {
          BackupDRGrpc.getGetManagementServerMethod =
              getGetManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.GetManagementServerRequest,
                          com.google.cloud.backupdr.v1.ManagementServer>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.GetManagementServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.ManagementServer.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("GetManagementServer"))
                      .build();
        }
      }
    }
    return getGetManagementServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateManagementServerRequest,
          com.google.longrunning.Operation>
      getCreateManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateManagementServer",
      requestType = com.google.cloud.backupdr.v1.CreateManagementServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.CreateManagementServerRequest,
          com.google.longrunning.Operation>
      getCreateManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.CreateManagementServerRequest,
            com.google.longrunning.Operation>
        getCreateManagementServerMethod;
    if ((getCreateManagementServerMethod = BackupDRGrpc.getCreateManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getCreateManagementServerMethod = BackupDRGrpc.getCreateManagementServerMethod)
            == null) {
          BackupDRGrpc.getCreateManagementServerMethod =
              getCreateManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.CreateManagementServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "CreateManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.CreateManagementServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("CreateManagementServer"))
                      .build();
        }
      }
    }
    return getCreateManagementServerMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
          com.google.longrunning.Operation>
      getDeleteManagementServerMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteManagementServer",
      requestType = com.google.cloud.backupdr.v1.DeleteManagementServerRequest.class,
      responseType = com.google.longrunning.Operation.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
          com.google.longrunning.Operation>
      getDeleteManagementServerMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
            com.google.longrunning.Operation>
        getDeleteManagementServerMethod;
    if ((getDeleteManagementServerMethod = BackupDRGrpc.getDeleteManagementServerMethod) == null) {
      synchronized (BackupDRGrpc.class) {
        if ((getDeleteManagementServerMethod = BackupDRGrpc.getDeleteManagementServerMethod)
            == null) {
          BackupDRGrpc.getDeleteManagementServerMethod =
              getDeleteManagementServerMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
                          com.google.longrunning.Operation>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "DeleteManagementServer"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.backupdr.v1.DeleteManagementServerRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.longrunning.Operation.getDefaultInstance()))
                      .setSchemaDescriptor(
                          new BackupDRMethodDescriptorSupplier("DeleteManagementServer"))
                      .build();
        }
      }
    }
    return getDeleteManagementServerMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static BackupDRStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDRStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDRStub>() {
          @java.lang.Override
          public BackupDRStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDRStub(channel, callOptions);
          }
        };
    return BackupDRStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static BackupDRBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDRBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDRBlockingStub>() {
          @java.lang.Override
          public BackupDRBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDRBlockingStub(channel, callOptions);
          }
        };
    return BackupDRBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static BackupDRFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<BackupDRFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<BackupDRFutureStub>() {
          @java.lang.Override
          public BackupDRFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BackupDRFutureStub(channel, callOptions);
          }
        };
    return BackupDRFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    default void listManagementServers(
        com.google.cloud.backupdr.v1.ListManagementServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListManagementServersResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListManagementServersMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    default void getManagementServer(
        com.google.cloud.backupdr.v1.GetManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ManagementServer>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetManagementServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    default void createManagementServer(
        com.google.cloud.backupdr.v1.CreateManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateManagementServerMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    default void deleteManagementServer(
        com.google.cloud.backupdr.v1.DeleteManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteManagementServerMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public abstract static class BackupDRImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return BackupDRGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public static final class BackupDRStub extends io.grpc.stub.AbstractAsyncStub<BackupDRStub> {
    private BackupDRStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDRStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDRStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    public void listManagementServers(
        com.google.cloud.backupdr.v1.ListManagementServersRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ListManagementServersResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListManagementServersMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    public void getManagementServer(
        com.google.cloud.backupdr.v1.GetManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ManagementServer>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetManagementServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    public void createManagementServer(
        com.google.cloud.backupdr.v1.CreateManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateManagementServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    public void deleteManagementServer(
        com.google.cloud.backupdr.v1.DeleteManagementServerRequest request,
        io.grpc.stub.StreamObserver<com.google.longrunning.Operation> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteManagementServerMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public static final class BackupDRBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<BackupDRBlockingStub> {
    private BackupDRBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDRBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDRBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ListManagementServersResponse listManagementServers(
        com.google.cloud.backupdr.v1.ListManagementServersRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListManagementServersMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    public com.google.cloud.backupdr.v1.ManagementServer getManagementServer(
        com.google.cloud.backupdr.v1.GetManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetManagementServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    public com.google.longrunning.Operation createManagementServer(
        com.google.cloud.backupdr.v1.CreateManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateManagementServerMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    public com.google.longrunning.Operation deleteManagementServer(
        com.google.cloud.backupdr.v1.DeleteManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteManagementServerMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service BackupDR.
   *
   * <pre>
   * The BackupDR Service
   * </pre>
   */
  public static final class BackupDRFutureStub
      extends io.grpc.stub.AbstractFutureStub<BackupDRFutureStub> {
    private BackupDRFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected BackupDRFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new BackupDRFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Lists ManagementServers in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ListManagementServersResponse>
        listManagementServers(com.google.cloud.backupdr.v1.ListManagementServersRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListManagementServersMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Gets details of a single ManagementServer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.backupdr.v1.ManagementServer>
        getManagementServer(com.google.cloud.backupdr.v1.GetManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetManagementServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates a new ManagementServer in a given project and location.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        createManagementServer(com.google.cloud.backupdr.v1.CreateManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateManagementServerMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Deletes a single ManagementServer.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.longrunning.Operation>
        deleteManagementServer(com.google.cloud.backupdr.v1.DeleteManagementServerRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteManagementServerMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_MANAGEMENT_SERVERS = 0;
  private static final int METHODID_GET_MANAGEMENT_SERVER = 1;
  private static final int METHODID_CREATE_MANAGEMENT_SERVER = 2;
  private static final int METHODID_DELETE_MANAGEMENT_SERVER = 3;

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
        case METHODID_LIST_MANAGEMENT_SERVERS:
          serviceImpl.listManagementServers(
              (com.google.cloud.backupdr.v1.ListManagementServersRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.backupdr.v1.ListManagementServersResponse>)
                  responseObserver);
          break;
        case METHODID_GET_MANAGEMENT_SERVER:
          serviceImpl.getManagementServer(
              (com.google.cloud.backupdr.v1.GetManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.backupdr.v1.ManagementServer>)
                  responseObserver);
          break;
        case METHODID_CREATE_MANAGEMENT_SERVER:
          serviceImpl.createManagementServer(
              (com.google.cloud.backupdr.v1.CreateManagementServerRequest) request,
              (io.grpc.stub.StreamObserver<com.google.longrunning.Operation>) responseObserver);
          break;
        case METHODID_DELETE_MANAGEMENT_SERVER:
          serviceImpl.deleteManagementServer(
              (com.google.cloud.backupdr.v1.DeleteManagementServerRequest) request,
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
            getListManagementServersMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.ListManagementServersRequest,
                    com.google.cloud.backupdr.v1.ListManagementServersResponse>(
                    service, METHODID_LIST_MANAGEMENT_SERVERS)))
        .addMethod(
            getGetManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.GetManagementServerRequest,
                    com.google.cloud.backupdr.v1.ManagementServer>(
                    service, METHODID_GET_MANAGEMENT_SERVER)))
        .addMethod(
            getCreateManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.CreateManagementServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_CREATE_MANAGEMENT_SERVER)))
        .addMethod(
            getDeleteManagementServerMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.backupdr.v1.DeleteManagementServerRequest,
                    com.google.longrunning.Operation>(service, METHODID_DELETE_MANAGEMENT_SERVER)))
        .build();
  }

  private abstract static class BackupDRBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    BackupDRBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.backupdr.v1.BackupDRProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("BackupDR");
    }
  }

  private static final class BackupDRFileDescriptorSupplier extends BackupDRBaseDescriptorSupplier {
    BackupDRFileDescriptorSupplier() {}
  }

  private static final class BackupDRMethodDescriptorSupplier extends BackupDRBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    BackupDRMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (BackupDRGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new BackupDRFileDescriptorSupplier())
                      .addMethod(getListManagementServersMethod())
                      .addMethod(getGetManagementServerMethod())
                      .addMethod(getCreateManagementServerMethod())
                      .addMethod(getDeleteManagementServerMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
