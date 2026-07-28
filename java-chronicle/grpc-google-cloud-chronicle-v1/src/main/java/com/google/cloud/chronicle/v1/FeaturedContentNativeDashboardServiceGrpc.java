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
package com.google.cloud.chronicle.v1;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 *
 *
 * <pre>
 * This service provides functionality for managing
 * FeaturedContentNativeDashboard.
 * </pre>
 */
@io.grpc.stub.annotations.GrpcGenerated
public final class FeaturedContentNativeDashboardServiceGrpc {

  private FeaturedContentNativeDashboardServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME =
      "google.cloud.chronicle.v1.FeaturedContentNativeDashboardService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest,
          com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>
      getGetFeaturedContentNativeDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetFeaturedContentNativeDashboard",
      requestType = com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest.class,
      responseType = com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest,
          com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>
      getGetFeaturedContentNativeDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest,
            com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>
        getGetFeaturedContentNativeDashboardMethod;
    if ((getGetFeaturedContentNativeDashboardMethod =
            FeaturedContentNativeDashboardServiceGrpc.getGetFeaturedContentNativeDashboardMethod)
        == null) {
      synchronized (FeaturedContentNativeDashboardServiceGrpc.class) {
        if ((getGetFeaturedContentNativeDashboardMethod =
                FeaturedContentNativeDashboardServiceGrpc
                    .getGetFeaturedContentNativeDashboardMethod)
            == null) {
          FeaturedContentNativeDashboardServiceGrpc.getGetFeaturedContentNativeDashboardMethod =
              getGetFeaturedContentNativeDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest,
                          com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(SERVICE_NAME, "GetFeaturedContentNativeDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturedContentNativeDashboardServiceMethodDescriptorSupplier(
                              "GetFeaturedContentNativeDashboard"))
                      .build();
        }
      }
    }
    return getGetFeaturedContentNativeDashboardMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>
      getListFeaturedContentNativeDashboardsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ListFeaturedContentNativeDashboards",
      requestType = com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest.class,
      responseType =
          com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest,
          com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>
      getListFeaturedContentNativeDashboardsMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest,
            com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>
        getListFeaturedContentNativeDashboardsMethod;
    if ((getListFeaturedContentNativeDashboardsMethod =
            FeaturedContentNativeDashboardServiceGrpc.getListFeaturedContentNativeDashboardsMethod)
        == null) {
      synchronized (FeaturedContentNativeDashboardServiceGrpc.class) {
        if ((getListFeaturedContentNativeDashboardsMethod =
                FeaturedContentNativeDashboardServiceGrpc
                    .getListFeaturedContentNativeDashboardsMethod)
            == null) {
          FeaturedContentNativeDashboardServiceGrpc.getListFeaturedContentNativeDashboardsMethod =
              getListFeaturedContentNativeDashboardsMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest,
                          com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "ListFeaturedContentNativeDashboards"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .ListFeaturedContentNativeDashboardsRequest.getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .ListFeaturedContentNativeDashboardsResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturedContentNativeDashboardServiceMethodDescriptorSupplier(
                              "ListFeaturedContentNativeDashboards"))
                      .build();
        }
      }
    }
    return getListFeaturedContentNativeDashboardsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest,
          com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>
      getInstallFeaturedContentNativeDashboardMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "InstallFeaturedContentNativeDashboard",
      requestType =
          com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest.class,
      responseType =
          com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<
          com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest,
          com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>
      getInstallFeaturedContentNativeDashboardMethod() {
    io.grpc.MethodDescriptor<
            com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest,
            com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>
        getInstallFeaturedContentNativeDashboardMethod;
    if ((getInstallFeaturedContentNativeDashboardMethod =
            FeaturedContentNativeDashboardServiceGrpc
                .getInstallFeaturedContentNativeDashboardMethod)
        == null) {
      synchronized (FeaturedContentNativeDashboardServiceGrpc.class) {
        if ((getInstallFeaturedContentNativeDashboardMethod =
                FeaturedContentNativeDashboardServiceGrpc
                    .getInstallFeaturedContentNativeDashboardMethod)
            == null) {
          FeaturedContentNativeDashboardServiceGrpc.getInstallFeaturedContentNativeDashboardMethod =
              getInstallFeaturedContentNativeDashboardMethod =
                  io.grpc.MethodDescriptor
                      .<com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest,
                          com.google.cloud.chronicle.v1
                              .InstallFeaturedContentNativeDashboardResponse>
                          newBuilder()
                      .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
                      .setFullMethodName(
                          generateFullMethodName(
                              SERVICE_NAME, "InstallFeaturedContentNativeDashboard"))
                      .setSampledToLocalTracing(true)
                      .setRequestMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .InstallFeaturedContentNativeDashboardRequest
                                  .getDefaultInstance()))
                      .setResponseMarshaller(
                          io.grpc.protobuf.ProtoUtils.marshaller(
                              com.google.cloud.chronicle.v1
                                  .InstallFeaturedContentNativeDashboardResponse
                                  .getDefaultInstance()))
                      .setSchemaDescriptor(
                          new FeaturedContentNativeDashboardServiceMethodDescriptorSupplier(
                              "InstallFeaturedContentNativeDashboard"))
                      .build();
        }
      }
    }
    return getInstallFeaturedContentNativeDashboardMethod;
  }

  /** Creates a new async stub that supports all call types for the service */
  public static FeaturedContentNativeDashboardServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturedContentNativeDashboardServiceStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<FeaturedContentNativeDashboardServiceStub>() {
          @java.lang.Override
          public FeaturedContentNativeDashboardServiceStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeaturedContentNativeDashboardServiceStub(channel, callOptions);
          }
        };
    return FeaturedContentNativeDashboardServiceStub.newStub(factory, channel);
  }

  /** Creates a new blocking-style stub that supports all types of calls on the service */
  public static FeaturedContentNativeDashboardServiceBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturedContentNativeDashboardServiceBlockingV2Stub>
        factory =
            new io.grpc.stub.AbstractStub.StubFactory<
                FeaturedContentNativeDashboardServiceBlockingV2Stub>() {
              @java.lang.Override
              public FeaturedContentNativeDashboardServiceBlockingV2Stub newStub(
                  io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new FeaturedContentNativeDashboardServiceBlockingV2Stub(
                    channel, callOptions);
              }
            };
    return FeaturedContentNativeDashboardServiceBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static FeaturedContentNativeDashboardServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturedContentNativeDashboardServiceBlockingStub>
        factory =
            new io.grpc.stub.AbstractStub.StubFactory<
                FeaturedContentNativeDashboardServiceBlockingStub>() {
              @java.lang.Override
              public FeaturedContentNativeDashboardServiceBlockingStub newStub(
                  io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new FeaturedContentNativeDashboardServiceBlockingStub(channel, callOptions);
              }
            };
    return FeaturedContentNativeDashboardServiceBlockingStub.newStub(factory, channel);
  }

  /** Creates a new ListenableFuture-style stub that supports unary calls on the service */
  public static FeaturedContentNativeDashboardServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<FeaturedContentNativeDashboardServiceFutureStub> factory =
        new io.grpc.stub.AbstractStub.StubFactory<
            FeaturedContentNativeDashboardServiceFutureStub>() {
          @java.lang.Override
          public FeaturedContentNativeDashboardServiceFutureStub newStub(
              io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new FeaturedContentNativeDashboardServiceFutureStub(channel, callOptions);
          }
        };
    return FeaturedContentNativeDashboardServiceFutureStub.newStub(factory, channel);
  }

  /**
   *
   *
   * <pre>
   * This service provides functionality for managing
   * FeaturedContentNativeDashboard.
   * </pre>
   */
  public interface AsyncService {

    /**
     *
     *
     * <pre>
     * Get a native dashboard featured content.
     * </pre>
     */
    default void getFeaturedContentNativeDashboard(
        com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getGetFeaturedContentNativeDashboardMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all native dashboards featured content.
     * </pre>
     */
    default void listFeaturedContentNativeDashboards(
        com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getListFeaturedContentNativeDashboardsMethod(), responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Install a native dashboard featured content.
     * </pre>
     */
    default void installFeaturedContentNativeDashboard(
        com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>
            responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(
          getInstallFeaturedContentNativeDashboardMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service FeaturedContentNativeDashboardService.
   *
   * <pre>
   * This service provides functionality for managing
   * FeaturedContentNativeDashboard.
   * </pre>
   */
  public abstract static class FeaturedContentNativeDashboardServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override
    public final io.grpc.ServerServiceDefinition bindService() {
      return FeaturedContentNativeDashboardServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service
   * FeaturedContentNativeDashboardService.
   *
   * <pre>
   * This service provides functionality for managing
   * FeaturedContentNativeDashboard.
   * </pre>
   */
  public static final class FeaturedContentNativeDashboardServiceStub
      extends io.grpc.stub.AbstractAsyncStub<FeaturedContentNativeDashboardServiceStub> {
    private FeaturedContentNativeDashboardServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturedContentNativeDashboardServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturedContentNativeDashboardServiceStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a native dashboard featured content.
     * </pre>
     */
    public void getFeaturedContentNativeDashboard(
        com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetFeaturedContentNativeDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * List all native dashboards featured content.
     * </pre>
     */
    public void listFeaturedContentNativeDashboards(
        com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getListFeaturedContentNativeDashboardsMethod(), getCallOptions()),
          request,
          responseObserver);
    }

    /**
     *
     *
     * <pre>
     * Install a native dashboard featured content.
     * </pre>
     */
    public void installFeaturedContentNativeDashboard(
        com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest request,
        io.grpc.stub.StreamObserver<
                com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>
            responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getInstallFeaturedContentNativeDashboardMethod(), getCallOptions()),
          request,
          responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service
   * FeaturedContentNativeDashboardService.
   *
   * <pre>
   * This service provides functionality for managing
   * FeaturedContentNativeDashboard.
   * </pre>
   */
  public static final class FeaturedContentNativeDashboardServiceBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<
          FeaturedContentNativeDashboardServiceBlockingV2Stub> {
    private FeaturedContentNativeDashboardServiceBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturedContentNativeDashboardServiceBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturedContentNativeDashboardServiceBlockingV2Stub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a native dashboard featured content.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard
        getFeaturedContentNativeDashboard(
            com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getGetFeaturedContentNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all native dashboards featured content.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse
        listFeaturedContentNativeDashboards(
            com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(), getListFeaturedContentNativeDashboardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Install a native dashboard featured content.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse
        installFeaturedContentNativeDashboard(
            com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest request)
            throws io.grpc.StatusException {
      return io.grpc.stub.ClientCalls.blockingV2UnaryCall(
          getChannel(),
          getInstallFeaturedContentNativeDashboardMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service
   * FeaturedContentNativeDashboardService.
   *
   * <pre>
   * This service provides functionality for managing
   * FeaturedContentNativeDashboard.
   * </pre>
   */
  public static final class FeaturedContentNativeDashboardServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<FeaturedContentNativeDashboardServiceBlockingStub> {
    private FeaturedContentNativeDashboardServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturedContentNativeDashboardServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturedContentNativeDashboardServiceBlockingStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a native dashboard featured content.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard
        getFeaturedContentNativeDashboard(
            com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetFeaturedContentNativeDashboardMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * List all native dashboards featured content.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse
        listFeaturedContentNativeDashboards(
            com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getListFeaturedContentNativeDashboardsMethod(), getCallOptions(), request);
    }

    /**
     *
     *
     * <pre>
     * Install a native dashboard featured content.
     * </pre>
     */
    public com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse
        installFeaturedContentNativeDashboard(
            com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(),
          getInstallFeaturedContentNativeDashboardMethod(),
          getCallOptions(),
          request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service
   * FeaturedContentNativeDashboardService.
   *
   * <pre>
   * This service provides functionality for managing
   * FeaturedContentNativeDashboard.
   * </pre>
   */
  public static final class FeaturedContentNativeDashboardServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<FeaturedContentNativeDashboardServiceFutureStub> {
    private FeaturedContentNativeDashboardServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected FeaturedContentNativeDashboardServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new FeaturedContentNativeDashboardServiceFutureStub(channel, callOptions);
    }

    /**
     *
     *
     * <pre>
     * Get a native dashboard featured content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>
        getFeaturedContentNativeDashboard(
            com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetFeaturedContentNativeDashboardMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * List all native dashboards featured content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>
        listFeaturedContentNativeDashboards(
            com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getListFeaturedContentNativeDashboardsMethod(), getCallOptions()),
          request);
    }

    /**
     *
     *
     * <pre>
     * Install a native dashboard featured content.
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<
            com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>
        installFeaturedContentNativeDashboard(
            com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getInstallFeaturedContentNativeDashboardMethod(), getCallOptions()),
          request);
    }
  }

  private static final int METHODID_GET_FEATURED_CONTENT_NATIVE_DASHBOARD = 0;
  private static final int METHODID_LIST_FEATURED_CONTENT_NATIVE_DASHBOARDS = 1;
  private static final int METHODID_INSTALL_FEATURED_CONTENT_NATIVE_DASHBOARD = 2;

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
        case METHODID_GET_FEATURED_CONTENT_NATIVE_DASHBOARD:
          serviceImpl.getFeaturedContentNativeDashboard(
              (com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>)
                  responseObserver);
          break;
        case METHODID_LIST_FEATURED_CONTENT_NATIVE_DASHBOARDS:
          serviceImpl.listFeaturedContentNativeDashboards(
              (com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>)
                  responseObserver);
          break;
        case METHODID_INSTALL_FEATURED_CONTENT_NATIVE_DASHBOARD:
          serviceImpl.installFeaturedContentNativeDashboard(
              (com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest) request,
              (io.grpc.stub.StreamObserver<
                      com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>)
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
            getGetFeaturedContentNativeDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.GetFeaturedContentNativeDashboardRequest,
                    com.google.cloud.chronicle.v1.FeaturedContentNativeDashboard>(
                    service, METHODID_GET_FEATURED_CONTENT_NATIVE_DASHBOARD)))
        .addMethod(
            getListFeaturedContentNativeDashboardsMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsRequest,
                    com.google.cloud.chronicle.v1.ListFeaturedContentNativeDashboardsResponse>(
                    service, METHODID_LIST_FEATURED_CONTENT_NATIVE_DASHBOARDS)))
        .addMethod(
            getInstallFeaturedContentNativeDashboardMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
                new MethodHandlers<
                    com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardRequest,
                    com.google.cloud.chronicle.v1.InstallFeaturedContentNativeDashboardResponse>(
                    service, METHODID_INSTALL_FEATURED_CONTENT_NATIVE_DASHBOARD)))
        .build();
  }

  private abstract static class FeaturedContentNativeDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier,
          io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    FeaturedContentNativeDashboardServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.google.cloud.chronicle.v1.FeaturedContentNativeDashboardProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("FeaturedContentNativeDashboardService");
    }
  }

  private static final class FeaturedContentNativeDashboardServiceFileDescriptorSupplier
      extends FeaturedContentNativeDashboardServiceBaseDescriptorSupplier {
    FeaturedContentNativeDashboardServiceFileDescriptorSupplier() {}
  }

  private static final class FeaturedContentNativeDashboardServiceMethodDescriptorSupplier
      extends FeaturedContentNativeDashboardServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    FeaturedContentNativeDashboardServiceMethodDescriptorSupplier(java.lang.String methodName) {
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
      synchronized (FeaturedContentNativeDashboardServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor =
              result =
                  io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
                      .setSchemaDescriptor(
                          new FeaturedContentNativeDashboardServiceFileDescriptorSupplier())
                      .addMethod(getGetFeaturedContentNativeDashboardMethod())
                      .addMethod(getListFeaturedContentNativeDashboardsMethod())
                      .addMethod(getInstallFeaturedContentNativeDashboardMethod())
                      .build();
        }
      }
    }
    return result;
  }
}
