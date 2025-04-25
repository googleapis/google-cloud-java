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
 * Service for managing [Versions][google.cloud.dialogflow.v2.Version].
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler",
    comments = "Source: google/cloud/dialogflow/v2/version.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class VersionsGrpc {

  private VersionsGrpc() {}

  public static final java.lang.String SERVICE_NAME = "google.cloud.dialogflow.v2.Versions";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListVersionsRequest,
          com.google.cloud.dialogflow.v2.ListVersionsResponse>
      getListVersionsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListVersions",
      requestType = com.google.cloud.dialogflow.v2.ListVersionsRequest.class,
      responseType = com.google.cloud.dialogflow.v2.ListVersionsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.ListVersionsRequest,
          com.google.cloud.dialogflow.v2.ListVersionsResponse>
      getListVersionsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.ListVersionsRequest,
            com.google.cloud.dialogflow.v2.ListVersionsResponse>
        getListVersionsMethod;
    if ((getListVersionsMethod = VersionsGrpc.getListVersionsMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getListVersionsMethod = VersionsGrpc.getListVersionsMethod) == null) {
          VersionsGrpc.getListVersionsMethod =
              getListVersionsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.ListVersionsRequest,
                          com.google.cloud.dialogflow.v2.ListVersionsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "ListVersions"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListVersionsRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.ListVersionsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("ListVersions"))
                      .build();
        }
      }
    }
    return getListVersionsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetVersionRequest, com.google.cloud.dialogflow.v2.Version>
      getGetVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetVersion",
      requestType = com.google.cloud.dialogflow.v2.GetVersionRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.GetVersionRequest, com.google.cloud.dialogflow.v2.Version>
      getGetVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.GetVersionRequest,
            com.google.cloud.dialogflow.v2.Version>
        getGetVersionMethod;
    if ((getGetVersionMethod = VersionsGrpc.getGetVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getGetVersionMethod = VersionsGrpc.getGetVersionMethod) == null) {
          VersionsGrpc.getGetVersionMethod =
              getGetVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.GetVersionRequest,
                          com.google.cloud.dialogflow.v2.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.GetVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("GetVersion"))
                      .build();
        }
      }
    }
    return getGetVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateVersionRequest,
          com.google.cloud.dialogflow.v2.Version>
      getCreateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CreateVersion",
      requestType = com.google.cloud.dialogflow.v2.CreateVersionRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.CreateVersionRequest,
          com.google.cloud.dialogflow.v2.Version>
      getCreateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.CreateVersionRequest,
            com.google.cloud.dialogflow.v2.Version>
        getCreateVersionMethod;
    if ((getCreateVersionMethod = VersionsGrpc.getCreateVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getCreateVersionMethod = VersionsGrpc.getCreateVersionMethod) == null) {
          VersionsGrpc.getCreateVersionMethod =
              getCreateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.CreateVersionRequest,
                          com.google.cloud.dialogflow.v2.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "CreateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.CreateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("CreateVersion"))
                      .build();
        }
      }
    }
    return getCreateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateVersionRequest,
          com.google.cloud.dialogflow.v2.Version>
      getUpdateVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "UpdateVersion",
      requestType = com.google.cloud.dialogflow.v2.UpdateVersionRequest.class,
      responseType = com.google.cloud.dialogflow.v2.Version.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.UpdateVersionRequest,
          com.google.cloud.dialogflow.v2.Version>
      getUpdateVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.UpdateVersionRequest,
            com.google.cloud.dialogflow.v2.Version>
        getUpdateVersionMethod;
    if ((getUpdateVersionMethod = VersionsGrpc.getUpdateVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getUpdateVersionMethod = VersionsGrpc.getUpdateVersionMethod) == null) {
          VersionsGrpc.getUpdateVersionMethod =
              getUpdateVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.UpdateVersionRequest,
                          com.google.cloud.dialogflow.v2.Version>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.UpdateVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.Version.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("UpdateVersion"))
                      .build();
        }
      }
    }
    return getUpdateVersionMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteVersionRequest, com.google.protobuf.Empty>
      getDeleteVersionMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "DeleteVersion",
      requestType = com.google.cloud.dialogflow.v2.DeleteVersionRequest.class,
      responseType = com.google.protobuf.Empty.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.dialogflow.v2.DeleteVersionRequest, com.google.protobuf.Empty>
      getDeleteVersionMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.dialogflow.v2.DeleteVersionRequest, com.google.protobuf.Empty>
        getDeleteVersionMethod;
    if ((getDeleteVersionMethod = VersionsGrpc.getDeleteVersionMethod) == null) {
      synchronized (VersionsGrpc.class) {
        if ((getDeleteVersionMethod = VersionsGrpc.getDeleteVersionMethod) == null) {
          VersionsGrpc.getDeleteVersionMethod =
              getDeleteVersionMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.dialogflow.v2.DeleteVersionRequest,
                          com.google.protobuf.Empty>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteVersion"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.dialogflow.v2.DeleteVersionRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.protobuf.Empty.getDefaultInstance()))
                      .setSchemaDescriptor(new VersionsMethodDescriptorSupplier("DeleteVersion"))
                      .build();
        }
      }
    }
    return getDeleteVersionMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static VersionsStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VersionsStub>() {
          @java.lang.Override
          public VersionsStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VersionsStub(channel, callOptions);
          }
        };
    return VersionsStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static VersionsBlockingStub newBlockingStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsBlockingStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VersionsBlockingStub>() {
          @java.lang.Override
          public VersionsBlockingStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VersionsBlockingStub(channel, callOptions);
          }
        };
    return VersionsBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static VersionsFutureStub newFutureStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<VersionsFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<VersionsFutureStub>() {
          @java.lang.Override
          public VersionsFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new VersionsFutureStub(channel, callOptions);
          }
        };
    return VersionsFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.v2.Version].
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Returns the list of all versions of the specified agent.
     * </pre>
     */
    default void listVersions(
        com.google.cloud.dialogflow.v2.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListVersionsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent version.
     * </pre>
     */
    default void getVersion(
        com.google.cloud.dialogflow.v2.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent version.
     * The new version points to the agent instance in the "default" environment.
     * </pre>
     */
    default void createVersion(
        com.google.cloud.dialogflow.v2.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getCreateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent version.
     * Note that this method does not allow you to update the state of the agent
     * the given version points to. It allows you to update only mutable
     * properties of the version resource.
     * </pre>
     */
    default void updateVersion(
        com.google.cloud.dialogflow.v2.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getUpdateVersionMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the specified agent version.
     * </pre>
     */
    default void deleteVersion(
        com.google.cloud.dialogflow.v2.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getDeleteVersionMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service Versions.
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.v2.Version].
   * </pre>
   */
  public abstract static class VersionsImplBase implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return VersionsGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service Versions.
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.v2.Version].
   * </pre>
   */
  public static final class VersionsStub extends io.grpc.stub.AbstractAsyncStub<VersionsStub> {
    private VersionsStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all versions of the specified agent.
     * </pre>
     */
    public void listVersions(
        com.google.cloud.dialogflow.v2.ListVersionsRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListVersionsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent version.
     * </pre>
     */
    public void getVersion(
        com.google.cloud.dialogflow.v2.GetVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent version.
     * The new version points to the agent instance in the "default" environment.
     * </pre>
     */
    public void createVersion(
        com.google.cloud.dialogflow.v2.CreateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent version.
     * Note that this method does not allow you to update the state of the agent
     * the given version points to. It allows you to update only mutable
     * properties of the version resource.
     * </pre>
     */
    public void updateVersion(
        com.google.cloud.dialogflow.v2.UpdateVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Delete the specified agent version.
     * </pre>
     */
    public void deleteVersion(
        com.google.cloud.dialogflow.v2.DeleteVersionRequest request,
        io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service Versions.
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.v2.Version].
   * </pre>
   */
  public static final class VersionsBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<VersionsBlockingStub> {
    private VersionsBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all versions of the specified agent.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.ListVersionsResponse listVersions(
        com.google.cloud.dialogflow.v2.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListVersionsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent version.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Version getVersion(
        com.google.cloud.dialogflow.v2.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent version.
     * The new version points to the agent instance in the "default" environment.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Version createVersion(
        com.google.cloud.dialogflow.v2.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getCreateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent version.
     * Note that this method does not allow you to update the state of the agent
     * the given version points to. It allows you to update only mutable
     * properties of the version resource.
     * </pre>
     */
    public com.google.cloud.dialogflow.v2.Version updateVersion(
        com.google.cloud.dialogflow.v2.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateVersionMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the specified agent version.
     * </pre>
     */
    public com.google.protobuf.Empty deleteVersion(
        com.google.cloud.dialogflow.v2.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getDeleteVersionMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service Versions.
   *
   * <pre>
   * Service for managing [Versions][google.cloud.dialogflow.v2.Version].
   * </pre>
   */
  public static final class VersionsFutureStub
      extends io.grpc.stub.AbstractFutureStub<VersionsFutureStub> {
    private VersionsFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected VersionsFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new VersionsFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Returns the list of all versions of the specified agent.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.ListVersionsResponse>
        listVersions(com.google.cloud.dialogflow.v2.ListVersionsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListVersionsMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Retrieves the specified agent version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Version>
        getVersion(com.google.cloud.dialogflow.v2.GetVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Creates an agent version.
     * The new version points to the agent instance in the "default" environment.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Version>
        createVersion(com.google.cloud.dialogflow.v2.CreateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getCreateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Updates the specified agent version.
     * Note that this method does not allow you to update the state of the agent
     * the given version points to. It allows you to update only mutable
     * properties of the version resource.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.dialogflow.v2.Version>
        updateVersion(com.google.cloud.dialogflow.v2.UpdateVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateVersionMethod(), getCallOptions()), request);
    }

    /**
     *
     *
     * <pre>
     * Delete the specified agent version.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty>
        deleteVersion(com.google.cloud.dialogflow.v2.DeleteVersionRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getDeleteVersionMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_LIST_VERSIONS = 0;
  private static final int METHODID_GET_VERSION = 1;
  private static final int METHODID_CREATE_VERSION = 2;
  private static final int METHODID_UPDATE_VERSION = 3;
  private static final int METHODID_DELETE_VERSION = 4;

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
        case METHODID_LIST_VERSIONS:
          serviceImpl.listVersions(
              (com.google.cloud.dialogflow.v2.ListVersionsRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.ListVersionsResponse>)
                  responseObserver);
          break;
        case METHODID_GET_VERSION:
          serviceImpl.getVersion(
              (com.google.cloud.dialogflow.v2.GetVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version>)
                  responseObserver);
          break;
        case METHODID_CREATE_VERSION:
          serviceImpl.createVersion(
              (com.google.cloud.dialogflow.v2.CreateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version>)
                  responseObserver);
          break;
        case METHODID_UPDATE_VERSION:
          serviceImpl.updateVersion(
              (com.google.cloud.dialogflow.v2.UpdateVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.cloud.dialogflow.v2.Version>)
                  responseObserver);
          break;
        case METHODID_DELETE_VERSION:
          serviceImpl.deleteVersion(
              (com.google.cloud.dialogflow.v2.DeleteVersionRequest) request,
              (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
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
            getListVersionsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.ListVersionsRequest,
                    com.google.cloud.dialogflow.v2.ListVersionsResponse>(
                    service, METHODID_LIST_VERSIONS)))
        .addMethod(
            getGetVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.GetVersionRequest,
                    com.google.cloud.dialogflow.v2.Version>(service, METHODID_GET_VERSION)))
        .addMethod(
            getCreateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.CreateVersionRequest,
                    com.google.cloud.dialogflow.v2.Version>(service, METHODID_CREATE_VERSION)))
        .addMethod(
            getUpdateVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.UpdateVersionRequest,
                    com.google.cloud.dialogflow.v2.Version>(service, METHODID_UPDATE_VERSION)))
        .addMethod(
            getDeleteVersionMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.dialogflow.v2.DeleteVersionRequest, com.google.protobuf.Empty>(
                    service, METHODID_DELETE_VERSION)))
        .build();
  }

  private abstract static class VersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    VersionsBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.dialogflow.v2.VersionProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Versions");
    }
  }

  private static final class VersionsFileDescriptorSupplier extends VersionsBaseDescriptorSupplier {
    VersionsFileDescriptorSupplier() {}
  }

  private static final class VersionsMethodDescriptorSupplier extends VersionsBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    VersionsMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (VersionsGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(new VersionsFileDescriptorSupplier())
                      .addMethod(getListVersionsMethod())
                      .addMethod(getGetVersionMethod())
                      .addMethod(getCreateVersionMethod())
                      .addMethod(getUpdateVersionMethod())
                      .addMethod(getDeleteVersionMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
